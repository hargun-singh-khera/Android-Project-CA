package com.example.salarymanagementsystem

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity5 : AppCompatActivity() {
    lateinit var optionSelectedForMonth: String
    lateinit var salaryMonth: Spinner
    lateinit var leaveWithoutPayDays: EditText
    lateinit var sharedPreference: SharedPreferences
    val fileName = "employeeSalaryGen"
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        salaryMonth =  findViewById(R.id.salaryMonth)
        leaveWithoutPayDays = findViewById(R.id.leaveWithoutPayDays)
        val salaryGen = findViewById<Button>(R.id.salaryGen)

        sharedPreference=getSharedPreferences(fileName, Context.MODE_PRIVATE)

        monthSpinner()

        salaryGen.setOnClickListener {
                saveDetails()
                Toast.makeText(this, "Salary Generated Successfully", Toast.LENGTH_SHORT).show()
        }

        val backToMainMenuBtn = findViewById<Button>(R.id.backToMainMenuBtn)
        backToMainMenuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun monthSpinner() {
        val month = arrayOf("January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
        optionSelectedForMonth = ""
        if (salaryMonth!=null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, month)
            salaryMonth.adapter = adapter

            salaryMonth.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    optionSelectedForMonth = month[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }

    fun saveDetails() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val salaryMonth = optionSelectedForMonth

            var leaveWithoutPayDay = leaveWithoutPayDays.text.toString()
            val edit=sharedPreference.edit()

            if (leaveWithoutPayDays.text.isEmpty()) {
                leaveWithoutPayDay="0"
                edit.putString("LeaveWithoutPayDays", leaveWithoutPayDay)
            }

            edit.putString("SalaryMonth", salaryMonth)
            edit.putString("LeaveWithoutPayDays", leaveWithoutPayDay)
            edit.apply()
        }

    }
}