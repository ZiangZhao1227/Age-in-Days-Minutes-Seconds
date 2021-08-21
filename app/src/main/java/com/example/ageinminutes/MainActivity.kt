package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btnDatePicker)


        button.setOnClickListener {
            clickDatePicker()

        }
    }


    fun clickDatePicker() {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DATE)

        val date = findViewById<TextView>(R.id.tvSelectedDate)
        val minutesFromBirth = findViewById<TextView>(R.id.tvSelectedDateInMinutes)
        val daysFromBirth = findViewById<TextView>(R.id.tvSelectedDateInDays)
        val secondsFromBirth = findViewById<TextView>(R.id.tvSelectedDateInSecs)

        val datePickerDialog1 = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDate ->

                val exactDay = "$selectedDate/${selectedMonth + 1}/$selectedYear"
                date.text = exactDay

                val yearToMins = (year - selectedYear) * 365 * 24 * 60
                val monthToMins = (month - selectedMonth) * 30 * 24 * 60
                val dayToMins = (day - selectedDate) * 24 * 60
                val totalInMins: Int = yearToMins + monthToMins + dayToMins

                minutesFromBirth.text = "$totalInMins"
                daysFromBirth.text = "${totalInMins / 1440}"
                secondsFromBirth.text = "${totalInMins * 60}"
            },
            year,
            month,
            day
        )

        datePickerDialog1.datePicker.maxDate = System.currentTimeMillis()
        datePickerDialog1.show();


    }

}