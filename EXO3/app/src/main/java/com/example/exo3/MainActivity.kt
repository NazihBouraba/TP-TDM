package com.example.exo3

import android.app.DatePickerDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var cal = Calendar.getInstance()
    var context = this
    var tachejour = ArrayList<Tache>()
    var tachesemaine = ArrayList<Tache>()
    var toutelestaches = ArrayList<Tache>()
    var tacheadapter = TacheAdapter(tachejour, this)
    var cal1 = Calendar.getInstance()
    private val TAG = "MyActivity"


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = tacheadapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->

                if (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    val myFormat = "dd" // mention the format you need
                    val sdf = SimpleDateFormat(myFormat, Locale.US)
                    if (sdf.format(updateDateInView().getTime())== sdf.format(cal1.getTime())){
                        tachejour.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                        toutelestaches.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                        tacheadapter.notifyDataSetChanged()}
                    else{
                        if ((sdf.format(updateDateInView().getTime())> sdf.format(cal1.getTime()))&&sdf.format(updateDateInView().getTime())< sdf.format(cal1.getTime())+7){
                            tachesemaine.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                            toutelestaches.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))

                        }
                    }

                }




            if (isTablet(context)&& false){

                val myFormat = "dd" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                if (sdf.format(updateDateInView().getTime())== sdf.format(cal1.getTime())){
                    tachejour.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                    tacheadapter.notifyDataSetChanged()}
                else{
                    if ((sdf.format(updateDateInView().getTime())> sdf.format(cal1.getTime()))&&sdf.format(updateDateInView().getTime())< sdf.format(cal1.getTime())+7){
                        tachesemaine.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                        Log.v(TAG,"\nhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh\n")
                    }
                }

//                toutelestaches.addAll(tachesemaine)
//                toutelestaches.addAll(tachejour)

            var spin = arrayOf("cette journnée","cette semaine","toutes les taches")
            var spinadapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,spin)
                spinner.adapter =spinadapter

                spinner.onItemSelectedListener= object :
                    AdapterView.OnItemSelectedListener{
                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        Log.v(TAG,"nothing selected")
                    }

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                    }


                }
            }






            if(context.resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){

                val myFormat = "dd" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                if (sdf.format(updateDateInView().getTime())== sdf.format(cal1.getTime())){
                    tachejour.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                    toutelestaches.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                    tacheadapter.notifyDataSetChanged()}
                else if (sdf.format(updateDateInView().getTime())!= sdf.format(cal1.getTime())){


                        tachesemaine.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))
                        toutelestaches.add(Tache(text.text.toString(), tt.text.toString(), updateDateInView()))

                }





                val radioGroup = findViewById<RadioGroup>(R.id.group1)

                radioGroup?.setOnCheckedChangeListener { group, checkedId ->

                    if (R.id.radio1 == checkedId) {


                        tacheadapter = TacheAdapter(tachejour, this)
                        recyclerView.adapter = tacheadapter
                        tacheadapter.notifyDataSetChanged()

                    }

                    if (R.id.radio2 == checkedId) {
                        tacheadapter = TacheAdapter(tachesemaine, this)
                        recyclerView.adapter = tacheadapter
                        tacheadapter.notifyDataSetChanged()


                    }

                    if (R.id.radio3 == checkedId) {
                        recyclerView.refreshDrawableState()
                        recyclerView.requestFocus()
                        tacheadapter = TacheAdapter(toutelestaches, this)
                        recyclerView.adapter = tacheadapter
                        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
                        tacheadapter.notifyDataSetChanged()

                    }

                }



            }




        }






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
        dab!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(
                    this@MainActivity,
                    dateSetListener,
                    // set DatePickerDialog to point to today's date when it loads up
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)
                ).show()
            }

        })
    }


    private fun updateDateInView(): Calendar {
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        return cal
    }

    fun isTablet(context: Context): Boolean {
        val xlarge = context.getResources()
            .getConfiguration().screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK === Configuration.SCREENLAYOUT_SIZE_XLARGE
        val large = context.getResources()
            .getConfiguration().screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK === Configuration.SCREENLAYOUT_SIZE_LARGE
        return xlarge || large
    }


}
