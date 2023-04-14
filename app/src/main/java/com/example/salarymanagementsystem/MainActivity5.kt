package com.example.salarymanagementsystem

import android.content.Context
import android.content.SharedPreferences
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

        salaryGen.setOnClickListener {
            saveDetails()
            Toast.makeText(this, "Salary Generated Successfully", Toast.LENGTH_SHORT).show()
        }
    }

    fun saveDetails() {
        val salaryMonth = optionSelectedForMonth
        val leaveWithoutPayDays = leaveWithoutPayDays.text.toString()
        val edit=sharedPreference.edit()

        edit.putString("SalaryMonth", salaryMonth)
        edit.putString("LeaveWithoutPayDays", leaveWithoutPayDays)
        edit.apply()
    }
}