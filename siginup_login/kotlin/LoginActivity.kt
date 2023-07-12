package com.example.sign_up_login_ee

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    lateinit var loginusername: EditText
    lateinit var loginpassword: EditText
    lateinit var loginbtn: Button
    var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginusername = findViewById(R.id.Login_Username)
        loginpassword = findViewById(R.id.Login_Password)
        loginbtn = findViewById(R.id.Login)
        val bundle:Bundle? = intent.extras
        val user:String? = bundle?.getString("username")
        val pass:String? = bundle?.getString("password")

        loginbtn.setOnClickListener {
            validateloginuser(user,pass);
        }
    }

    private fun validateloginuser(user:String?, pass:String?) {
        val uname:String = loginusername.text.toString()
        val pwd: String = loginpassword.text.toString()
        if(uname==user && pwd==pass)
        {
            val intent = Intent(this,SucessActivity::class.java)
            startActivity(intent)
        }
        else{
            count++
            if(count>3)
            {
                Toast.makeText(this, "Failed Login Attempts: $count",Toast.LENGTH_SHORT).show()
                loginbtn.isEnabled = false
            }else{
                Toast.makeText(this, "Login Failed: $count ",Toast.LENGTH_SHORT).show()
            }
        }
    }
}