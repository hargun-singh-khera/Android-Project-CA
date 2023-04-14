package com.example.salarymanagementsystem

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.properties.Delegates

class MainActivity7 : AppCompatActivity() {
    lateinit var grossSalaryDisplay: TextView
    lateinit var providentFundDisplay: TextView
    lateinit var incomeTaxDisplay: TextView
    lateinit var netSalaryDisplay: TextView
    lateinit var sharedPreferences: SharedPreferences
    var providentFund: Float = 0f
    var incomeTax:Float=0f
    var grossSalary: Float= 0f
    var netSalary:Float=0f
    var noOfDaysInMonth=30

    val fileName = "employeeDetails"
    val fileNameSecond = "employeeSalaryGen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        grossSalaryDisplay=findViewById(R.id.grossSalaryDisplay)
        providentFundDisplay=findViewById(R.id.providentFundDisplay)
        incomeTaxDisplay=findViewById(R.id.incomeTaxDisplay)
        netSalaryDisplay=findViewById(R.id.netSalaryDisplay)


        getEmployeeDetails()
    }

    fun getEmployeeDetails() {
        sharedPreferences=getSharedPreferences(fileName, Context.MODE_PRIVATE)
        val basicSalary = sharedPreferences.getString("EmpBasicSalary","")!!.toFloat()
        val dearnessAllowance = sharedPreferences.getString("EmpDearnessAllowance","")!!.toFloat()
        val travellingAllowance = sharedPreferences.getString("EmpTravellingAllowance", "")!!.toFloat()
        val homeRentalAllowance = sharedPreferences.getString("EmpRentalAllowance", "")!!.toFloat()
        val otherAllowance = sharedPreferences.getString("EmpOtherAllowance", "")!!.toFloat()
        sharedPreferences=getSharedPreferences(fileNameSecond, Context.MODE_PRIVATE)
        val noOfLeaveDays = sharedPreferences.getString("LeaveWithoutPayDays", "")!!.toFloat()

        val basicSalaryWithLeave = ((noOfDaysInMonth - noOfLeaveDays)*basicSalary)/noOfDaysInMonth
        val dearnessAllowanceWithLeave = ((noOfDaysInMonth - noOfLeaveDays)*dearnessAllowance)/noOfDaysInMonth
        val travellingAllowanceWithLeave = ((noOfDaysInMonth - noOfLeaveDays)*travellingAllowance)/noOfDaysInMonth
        val homeRentalAllowanceWithLeave = ((noOfDaysInMonth - noOfLeaveDays)*homeRentalAllowance)/noOfDaysInMonth
        val otherAllowanceWithLeave = ((noOfDaysInMonth - noOfLeaveDays)*otherAllowance)/noOfDaysInMonth

        grossSalary = basicSalaryWithLeave + dearnessAllowanceWithLeave + travellingAllowanceWithLeave + homeRentalAllowanceWithLeave + otherAllowanceWithLeave
        providentFund = (grossSalary*12)/100
        incomeTax = (grossSalary*10)/100

        netSalary = grossSalary - providentFund - incomeTax

        grossSalaryDisplay.setText(grossSalary.toString())
        providentFundDisplay.setText(providentFund.toString())
        incomeTaxDisplay.setText(incomeTax.toString())
        netSalaryDisplay.setText(netSalary.toString())
    }

}