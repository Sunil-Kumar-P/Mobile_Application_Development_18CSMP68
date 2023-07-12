package com.example.wallpaper_ee

import android.app.WallpaperManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    var mywallpaperlist:Array<Int> = arrayOf(R.drawable.bg1, R.drawable.bg2, R.drawable.bg3)
    private lateinit var changewallpaper: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changewallpaper = findViewById(R.id.btnid)
        changewallpaper.setOnClickListener{ setWallpaper() }
    }
    fun setWallpaper() {
        Toast.makeText(this,"Setting Wallpaper wait", Toast.LENGTH_SHORT).show()
        Handler().postDelayed(
            {
                for(i in mywallpaperlist)
                {
                    val manager = WallpaperManager.getInstance(baseContext)
                    manager.setResource(i)
                    Thread.sleep(3000)
                }
            }
            , 3000)
    }
}