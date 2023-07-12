package com.example.calculator_iat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    lateinit var zero: TextView
    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var add: TextView
    lateinit var sub: TextView
    lateinit var mul: TextView
    lateinit var div: TextView
    lateinit var dot: TextView
    lateinit var result: TextView
    lateinit var input: TextView
    lateinit var clear: TextView
    lateinit var equal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero = findViewById(R.id.zero)
        one  = findViewById(R.id.one)
        two  = findViewById(R.id.two)
        three  = findViewById(R.id.three)
        four  = findViewById(R.id.four)
        five  = findViewById(R.id.five)
        six  = findViewById(R.id.six)
        seven  = findViewById(R.id.seven)
        eight  = findViewById(R.id.eight)
        nine  = findViewById(R.id.nine)
        add = findViewById(R.id.add)
        sub  = findViewById(R.id.subtract)
        mul  = findViewById(R.id.multiply)
        div  = findViewById(R.id.divide)
        dot  = findViewById(R.id.dot)
        result  = findViewById(R.id.result)
        input  = findViewById(R.id.input)
        clear  = findViewById(R.id.clear)
        equal  = findViewById(R.id.equal)


        zero.setOnClickListener {
            pressButton("0")
        }

        one.setOnClickListener {
            pressButton("1")
        }

        two.setOnClickListener {
            pressButton("2")
        }

        three.setOnClickListener {
            pressButton("3")
        }

        four.setOnClickListener {
            pressButton("4")
        }
        five.setOnClickListener {
            pressButton("5")
        }
        six.setOnClickListener {
            pressButton("6")
        }
        seven.setOnClickListener {
            pressButton("7")
        }
        eight.setOnClickListener {
            pressButton("8")
        }
        nine.setOnClickListener {
            pressButton("9")
        }

        add.setOnClickListener {
            pressButton("+")
        }
        sub.setOnClickListener {
            pressButton("-")
        }
        mul.setOnClickListener {
            pressButton("*")
        }
        div.setOnClickListener {
            pressButton("/")
        }
        dot.setOnClickListener {
            pressButton(".")
        }

        clear.setOnClickListener {
            result.text=""
            input.text = ""
        }

        equal.setOnClickListener{
            try{
                val text = input.text.toString()
                val expression = ExpressionBuilder(text).build()
                val expResult = expression.evaluate().toDouble()
                result.text = expResult.toString()
            }
            catch (e:Exception){
                result.text = "Error"
            }
        }


    }
    fun pressButton(str:String)
    {
        result.text = ""
        input.append(str)
    }
}