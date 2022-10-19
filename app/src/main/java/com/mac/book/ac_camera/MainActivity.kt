package com.mac.book.ac_camera

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mac.book.ac_camera.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var  model :MyViewmodel
    lateinit var  binding :ActivityMainBinding
    var mInt = 1  //判断 +/- 号  1为 +
    var isnewOp = true  //为true 清除显示框 text = “”  为空   false 不做操作
    var vInt = ""
    var _op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        model = ViewModelProviders.of(this).get(MyViewmodel::class.java)
    }

    //数字键
    fun numberButtClick(view:View){
        if (isnewOp){
            binding.etNumber.text = ""
            isnewOp = false
        }
        var buclick = binding.etNumber.text.toString()
        var btn = view as Button
        when(btn.id){
            binding.btn1.id -> {buclick += "1"}
            binding.btn2.id -> {buclick += "2"}
            binding.btn3.id -> {buclick += "3"}
            binding.btn4.id -> {buclick += "4"}
            binding.btn5.id -> {buclick += "5"}
            binding.btn6.id -> {buclick += "6"}
            binding.btn7.id -> {buclick += "7"}
            binding.btn8.id -> {buclick += "8"}
            binding.btn9.id -> {buclick += "9"}
            binding.btn0.id -> {buclick += "0"}
            //点击 +/- 获得正 负数
            binding.btnJj.id -> if (mInt==1){
                buclick = "-$buclick"
                mInt=2
            }else{
                buclick = "${buclick.replace("-","")}"
                mInt = 1
            }
            binding.btnDian.id -> {buclick += "."}
        }
        binding.etNumber.text = buclick
    }
    //运算符
    fun operatorButtClick(view: View){
        isnewOp = true
        vInt = binding.etNumber.text.toString()
        var btn = view as Button
        when(btn.id){
            binding.btnJa.id -> _op = "+"
            binding.btnJian.id -> _op = "-"
            binding.btnXx.id -> _op = "*"
            binding.btnCc.id -> _op = "/"
        }
    }
    //请空键
    fun clearButtClick(view: View){
        var btn_cl = view as Button
        when(btn_cl.id){
            binding.btnAc.id ->binding.etNumber.text = "0"
        }
        isnewOp = true
    }
    //撤销键
    fun backButtClick(view: View){

    }
    //=键
    fun equalButtClick(view: View){
        var newNumber = binding.etNumber.text.toString()
        var number1 = newNumber
        var sum = 0.0
        var btn = view as Button
        when(_op){
            "+" -> {sum = vInt.toDouble() + newNumber.toDouble()}
            "-" -> {sum = vInt.toDouble() - newNumber.toDouble()}
            "*" -> {sum = vInt.toDouble() * newNumber.toDouble()}
            "/" -> {sum = vInt.toDouble() / newNumber.toDouble()}
        }

        vInt = number1
        binding.etNumber.text = sum.toString()
    }
}