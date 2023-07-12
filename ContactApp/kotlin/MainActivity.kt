package com.example.dialer_contactapp_ee

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView


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
    lateinit var contact: TextView
    lateinit var star: TextView
    lateinit var hash: TextView
    lateinit var save: Button
    lateinit var clear: TextView
    lateinit var call: Button

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
        contact  = findViewById(R.id.contact)
        call  = findViewById(R.id.call)
        star  = findViewById(R.id.star)
        hash  = findViewById(R.id.hash)
        save  = findViewById(R.id.save)
        clear  = findViewById(R.id.clear)

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
        star.setOnClickListener {
            pressButton("*")
        }
        hash.setOnClickListener {
            pressButton("#")
        }
        clear.setOnClickListener {
            contact.text=""
        }

        call.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+contact.text))
            startActivity(intent)
        }
        save.setOnClickListener {
            val intent = Intent(ContactsContract.Intents.SHOW_OR_CREATE_CONTACT, Uri.parse("tel:"+contact.text))
            intent.putExtra(ContactsContract.Intents.EXTRA_FORCE_CREATE, true)
            startActivity(intent)
        }

    }
    fun pressButton(str:String)
    {
        contact.append(str)
    }
}