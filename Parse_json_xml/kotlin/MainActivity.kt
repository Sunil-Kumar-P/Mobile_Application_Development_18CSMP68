package com.example.a1cr21cs414_json_xml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import javax.xml.parsers.DocumentBuilderFactory

class MainActivity : AppCompatActivity() {

    lateinit var parseXMLbtn:Button
    lateinit var parseJSONbtn:Button
    lateinit var city_name:TextView
    lateinit var longitude:TextView
    lateinit var latitude:TextView
    lateinit var temperature:TextView
    lateinit var humidity: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        parseXMLbtn = findViewById(R.id.xml_parse)
        parseJSONbtn = findViewById(R.id.json_parse)
        city_name = findViewById(R.id.city_name)
        longitude = findViewById(R.id.longitude)
        latitude = findViewById(R.id.latitude)
        temperature = findViewById(R.id.temperature)
        humidity = findViewById(R.id.humidity)

        parseJSONbtn.setOnClickListener {
            parseJSON()
        }
        parseXMLbtn.setOnClickListener {
            parseXML()
        }
    }
    private fun parseXML() {
        val input = assets.open("myxml.xml")
        val dbf = DocumentBuilderFactory.newInstance()
        val docBuild = dbf.newDocumentBuilder()
        val doc = docBuild.parse(input)

        city_name.text = doc.getElementsByTagName("city_name").item(0).firstChild.nodeValue
        longitude.text = doc.getElementsByTagName("longitude").item(0 ).firstChild.nodeValue
        latitude.text = doc.getElementsByTagName("latitude").item(0).firstChild.nodeValue
        temperature.text = doc.getElementsByTagName("temperature").item(0).firstChild.nodeValue
        humidity.text = doc.getElementsByTagName("humidity").item(0).firstChild.nodeValue
    }
    private fun parseJSON() {
        val obj = JSONObject(jparse())
        city_name.text = obj.getString("city_name")
        longitude.text = obj.getString("longitude")
        latitude.text = obj.getString("latitude")
        temperature.text = obj.getString("temperature")
        humidity.text = obj.getString("humidity")
    }
    private fun jparse() : String {
        val json: String
        try {
            val input = assets.open("myjson.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            val charset: Charset = Charsets.UTF_8
            json = String(buffer, charset)
        } catch (ex: IOException)
        {
            return ""
        }
        return json
    }
}