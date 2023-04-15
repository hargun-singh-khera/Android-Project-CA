package com.example.salarymanagementsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity10 : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    val myFile = "myProfile"
    var is_login = "login"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        sharedPreferences = getSharedPreferences(myFile , Context.MODE_PRIVATE)

        var btn = findViewById<Button>(R.id.start)
        var signout = findViewById<Button>(R.id.signOut)

        btn.setOnClickListener{
//login
            var int = Intent(this,MainActivity8::class.java);
            startActivity(int);
        }

        signout.setOnClickListener {

            val editor = sharedPreferences.edit()
            editor.putString(is_login , "false")
            editor.apply()
            Toast.makeText(this, "Logout Successfull", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}