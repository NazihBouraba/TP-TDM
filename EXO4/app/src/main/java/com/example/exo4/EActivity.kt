package com.example.exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_e.*

class EActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e)
        getincommingextra()
    }


    private fun getincommingextra(){
        if(intent.hasExtra("nom") && intent.hasExtra("cv") ){
            var titr = intent.getStringExtra("nom")
            var autuer = intent.getStringExtra("cv")
            setdetail(titr,autuer)
        }

    }

    private fun setdetail(t:String,a :String )
    {
        nom.text= t
        cv.text= a



    }
}
