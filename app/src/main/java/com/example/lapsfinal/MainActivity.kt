package com.example.lapsfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var buttonlogin : Button
    private lateinit var buttonsignin : Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonlogin=findViewById(R.id.login)
        buttonsignin=findViewById(R.id.signup)
        textView=findViewById(R.id.textView11)

        buttonlogin.setOnClickListener {
            val intent = Intent(this, LoginsActivity::class.java)
            startActivity(intent)
        }

        buttonsignin.setOnClickListener {
            val sign = Intent(this,SignupActivity::class.java)
            startActivity(sign)
        }
        }

}

