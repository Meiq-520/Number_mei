package com.mac.book.ac_camera

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewmodel(): ViewModel() {
    var counters = 0


    fun add(){
        counters++
    }
}