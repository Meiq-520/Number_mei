package com.mac.book.ac_camera

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mac.book.ac_camera.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var  model :MyViewmodel
    lateinit var  binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        model = ViewModelProviders.of(this).get(MyViewmodel::class.java)


        binding.btnJa.setOnClickListener {
            model.counters++
            binding.etNumber.text = model.counters.toString()
        }

        binding.btnAc.setOnClickListener {
            model.counters = 0
            binding.etNumber.text = model.counters.toString()
        }

    }

    //数字键
    fun numberButtClick(view:View){

    }
    //运算符
    fun operatorButtClick(view: View){

    }
    //请空键
    fun clearButtClick(view: View){

    }
    //撤销键
    fun backButtClick(view: View){

    }
    //=键
    fun equalButtClick(view: View){

    }

}