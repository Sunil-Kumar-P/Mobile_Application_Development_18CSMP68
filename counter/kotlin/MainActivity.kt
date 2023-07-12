package com.example.counter_ee

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    lateinit var countervalue: TextView
    lateinit var startbtn: Button
    lateinit var stopbtn: Button
    lateinit var resetbtn: Button
    val timer = Mycounter(10000,1000)
    var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countervalue = findViewById(R.id.cid)
        startbtn = findViewById(R.id.startid)
        stopbtn = findViewById(R.id.stopid)
        resetbtn = findViewById(R.id.resetid)

        startbtn.setOnClickListener {
            timer.start()
            startbtn.isEnabled = false
        }

        stopbtn.setOnClickListener {
            timer.cancel()
            startbtn.isEnabled = true
        }

        resetbtn.setOnClickListener {
            timer.cancel()
            startbtn.isEnabled = true
            count = 0
            countervalue.text = (count).toString()
        }
    }
    inner class  Mycounter(x : Long, y : Long): CountDownTimer(x,y)
    {
        override fun onTick(millisUntilFinished: Long)
        {
            count++
            countervalue.text = (count).toString()
        }

        override fun onFinish() {
            countervalue.text = "Finished"
            stopbtn.isEnabled = false
        }
    }

}