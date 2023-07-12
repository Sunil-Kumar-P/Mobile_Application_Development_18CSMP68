package com.example.texttospeech_ee

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.util.*


class MainActivity : AppCompatActivity() , TextToSpeech.OnInitListener{

    private lateinit var textinfo : EditText
    private lateinit var button: Button
    private lateinit var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        textinfo = findViewById(R.id.textinfo)
        textToSpeech = TextToSpeech(this, this)
        button = findViewById(R.id.button)


        button.setOnClickListener {
            converttospeech()
        }


    }

    private fun converttospeech() {
        var text = textinfo.text.toString()
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }



    override fun onInit(status: Int) {

        if (status == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.ENGLISH)
            val speed = 0.7
            textToSpeech.setSpeechRate(speed.toFloat())
        } else {
            Log.e("tts", "TTS package nit loaded")
        }
    }
}

