package com.example.myapplication

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)

        }
    }
        fun clickDatePicker(view: View) {
            val myCalender = Calendar.getInstance()
            var currentYear = myCalender.get(Calendar.YEAR)
            var currentMonth = myCalender.get(Calendar.MONTH)
            var currentDay = myCalender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, selectYear, selectedMonth, selectedDay ->Toast.makeText(this, "the year is $selectYear", Toast.LENGTH_SHORT).show()
                val selectedDate = "$selectedDay/${selectedMonth-1}/$selectYear"
                    tvselectedDate.text = selectedDate
                    val simpleDateFormat = SimpleDateFormat("DD/MM/YYYY", Locale.ENGLISH)
                    val theDate = simpleDateFormat.parse(selectedDate)

                    val years  = (currentYear-selectYear)
                    val months = (currentMonth -selectedMonth)
                    val days =  currentDay-selectedDay
                    val minutes =years*365*24*60+(months-1)*31*24*60+days*24*60
                    
                    tvSelectedDateInMinutes.text = "$minutes"
                },
                currentYear,
                currentMonth,
                currentDay

            ).show()
        }
    }



