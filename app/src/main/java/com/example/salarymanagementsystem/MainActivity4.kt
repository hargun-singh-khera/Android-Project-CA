package com.example.salarymanagementsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val backToEmployeeMasterMainMenuBtn = findViewById<Button>(R.id.backToEmployeeMasterMainMenuBtn)
        backToEmployeeMasterMainMenuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        val departmentSpinner = findViewById<Spinner>(R.id.departmentSpinner)
        val department = arrayOf("Select a department","Accounts","Production","Purchase","Sale","Marketing","Information Technology","Research & Development")
        var optionForDepartment=""

        if (departmentSpinner!=null) {
            val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,department)
            departmentSpinner.adapter=adapter

            departmentSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    optionForDepartment = department[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    optionForDepartment="Department"
                }
            }
        }

        val designationSpinner = findViewById<Spinner>(R.id.designationSpinner)
        val designation = arrayOf("Select a designation","Assistant Manager", "Senior Manager","Accountant","Account Manager","Software Engineer", "Data Entry Operator", "Programmer", "Clerk", "Labour")
        var optionForDesignation=""


        if (designationSpinner!=null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,designation)
            designationSpinner.adapter=adapter

            designationSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long
                ) {
                    optionForDesignation=designation[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }

        val empMobileNumber = findViewById<EditText>(R.id.empMobileNumber)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            if (!empMobileNumber.text.toString().isEmpty()) {
                if (empMobileNumber.length()<10 || empMobileNumber.length()>10) {
                    Toast.makeText(this, "Please enter a valid mobile number", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}