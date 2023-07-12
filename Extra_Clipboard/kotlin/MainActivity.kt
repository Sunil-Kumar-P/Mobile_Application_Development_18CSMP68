package com.example.clipboard414

import android.content.ClipData
import android.content.ClipboardManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    private lateinit var b1: Button
    private lateinit var b2: Button

    private lateinit var myClipboard: ClipboardManager
    private lateinit var myClip: ClipData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed1 = findViewById(R.id.ed1)
        ed2 = findViewById(R.id.ed2)

        b1 = findViewById(R.id.b1)
        b2 = findViewById(R.id.b2)

        myClipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        b1.setOnClickListener {
            val text = ed1.text.toString()

            myClip = ClipData.newPlainText("text", text)
            myClipboard.setPrimaryClip(myClip)

            Toast.makeText(applicationContext, "Text Copied", Toast.LENGTH_SHORT).show()
        }

        b2.setOnClickListener {
            val abc = myClipboard.primaryClip
            val item = abc?.getItemAt(0)

            val text = item?.text.toString()
            ed2.setText(text)

            Toast.makeText(applicationContext, "Text Pasted", Toast.LENGTH_SHORT).show()
        }
    }
}