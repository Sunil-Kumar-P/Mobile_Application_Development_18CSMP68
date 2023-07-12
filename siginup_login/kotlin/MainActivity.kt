package com.example.sign_up_login_ee

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Matcher
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var signupusername:EditText
    lateinit var signuppassword:EditText
    lateinit var siginbtn:Button
    val re = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,}$"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signupusername = findViewById(R.id.Login_Username)
        signuppassword = findViewById(R.id.Login_Password)
        siginbtn = findViewById(R.id.Login)
        siginbtn.setOnClickListener {
            fetchdetails();
        }
    }
    private  fun fetchdetails() {
        val uname : String = signupusername.text.toString()
        val pwd: String = signuppassword.text.toString()
        if(validate(pwd))
        {
            val bundle = Bundle()
            bundle.putString("username",uname)
            bundle.putString("password",pwd)
            intent = Intent(this,LoginActivity::class.java)
            intent.putExtras(bundle)

            startActivity(intent)
        }else{
            Toast.makeText(this,"Signup failed",Toast.LENGTH_SHORT).show()
        }
    }
    private fun validate(pwd:String):Boolean{
        val pattern:Pattern = Pattern.compile(re)
        val matcher: Matcher = pattern.matcher(pwd)
        return matcher.matches()
    }

}
