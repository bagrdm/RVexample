package com.example.rvexample

interface ButtonClickListener {

    fun addParent(position: Int)

    fun addChild(position: Int)

    fun removeParent(position: Int)

    fun removeChild(position: Int)
}
