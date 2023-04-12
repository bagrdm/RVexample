package com.example.rvexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {

    private val _data = MutableLiveData<List<RoomModel>>(listOf())
    val data: LiveData<List<RoomModel>> get() = _data

    fun addRoom() {
        val newList = mutableListOf<RoomModel>()
        _data.value?.let { newList.addAll(it) }
        newList.add(
            RoomModel(
                newList.size, 1, 0
            )
        )

        _data.value = newList
    }

    fun removeRoom(position: Int) {
        val newList = _data.value?.toMutableList() ?: mutableListOf()

        newList.removeAt(position)

        if (newList.isNotEmpty()) {
            newList.forEachIndexed { index, roomModel ->
                newList[index] = roomModel.copy(roomId = index)
            }
        }

        _data.value = newList
    }

//    private fun updateData() {
//        val newList = _data.value?.toMutableList() ?: mutableListOf()
//        if (newList.isNotEmpty()) {
//            newList.forEachIndexed { index, roomModel ->
//                newList[index] = roomModel.copy(roomId = index)
//            }
//        }
//    }

    fun addParent(position: Int) {
        val newList = _data.value?.toMutableList() ?: mutableListOf()
        val item = newList[position]
        val currentCount = item.parentCount
        val newItem = item.copy(parentCount = currentCount + 1)
        newList[position] = newItem
        _data.value = newList
    }

    fun addChild(position: Int) {

    }

    fun removeParent(position: Int) {

    }

    fun removeChild(position: Int) {

    }
}
