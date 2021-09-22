package com.example.calculateage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import kotlinx.android.synthetic.main.activity_birthday_card.*

class BirthdayCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday_card)
        var Age = intent.getStringExtra("age")
        var name = intent.getStringExtra("name")
        var BirthdayAge = Age?.toInt()

        if (BirthdayAge != null) {
            if(BirthdayAge%10 == 1)
            {
                Age = (Age + "st").toString()

            }

            else if(BirthdayAge%10 == 2)
            {
                Age = (Age + "nd").toString()

            }

            else if(BirthdayAge%10 == 3)
            {
                Age = (Age + "rd").toString()

            }
            else
            {
                Age = (Age + "th").toString()

            }
        }
        Birthday.text = "Happy $Age Birthday\n $name!  "
    }
}