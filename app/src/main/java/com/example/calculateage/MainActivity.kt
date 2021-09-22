package com.example.calculateage

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun select_Date(view: View) {
        var c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener
                            {View,Selected_year,Selected_month,Selected_day ->
                                var Selected = "$Selected_day/${Selected_month+1}/$Selected_year"
                                Selected_Date.text = Selected.toString()
                                var age = (c.get(Calendar.YEAR)-Selected_year)
                                No_of_Minute.text = age.toString()

                                if(age > 0)
                                    Generate_Card.isEnabled = true
                                else {
                                    Generate_Card.isEnabled = false
                                    Toast.makeText(this,"Age Should be Greater than 0",Toast.LENGTH_LONG).show()
                                }
                            }
                            ,year,month,day).show()


    }

    fun Createcard(view: View,) {
        var age = No_of_Minute.text.toString()
        var Namee = Name.text.toString()
        var intent = Intent(this,BirthdayCard::class.java)
        intent.putExtra("age",age)
        intent.putExtra("name",Namee)
        startActivity(intent)
    }


}