package com.example.salarymanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val addEmpBtn = findViewById<Button>(R.id.addEmpBtn)
        val backToMainMenuBtn = findViewById<Button>(R.id.backToMainMenuBtn)
        val displayEmpBtn = findViewById<Button>(R.id.displayEmpBtn)
        val editEmpBtn = findViewById<Button>(R.id.editEmpBtn)
        val deleteEmpBtn = findViewById<Button>(R.id.deleteEmpBtn)

        addEmpBtn.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        backToMainMenuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        displayEmpBtn.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        editEmpBtn.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            intent.putExtra("isEditable", true)
            startActivity(intent)
        }

        deleteEmpBtn.setOnClickListener {

        }

    }


}