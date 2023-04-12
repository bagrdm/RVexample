package com.example.rvexample

interface ButtonClickListener {

    fun removeRoom(position: Int)

    fun addParent(position: Int)

    fun addChild(position: Int)

    fun removeParent(position: Int)

    fun removeChild(position: Int)
}
