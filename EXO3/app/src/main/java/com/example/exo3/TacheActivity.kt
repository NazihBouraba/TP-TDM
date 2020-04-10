package com.example.exo3

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_tache.*
import kotlinx.android.synthetic.main.tache.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TacheActivity : AppCompatActivity() {

    var cal = Calendar.getInstance()
    var liste = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tache)



        if(intent.hasExtra("tache")  )
        {
            liste = intent.getStringArrayListExtra("tache")


        }

        // get the references from layout file

        var context = this


        // create an OnDateSetListener
        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInView()
            }
        }


        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        button!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@TacheActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })


        valider!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                var intent = Intent()
                intent.setClass(context,MainActivity::class.java)
                liste.add((text.text.toString()))
                intent.putExtra("tache",liste)
                context.startActivity(intent)

            }

        })


    }


    private fun updateDateInView() {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        text_date!!.text = sdf.format(cal.getTime())
    }


}

