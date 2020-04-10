package com.example.exo4

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.detail.*

class DetailActivity : AppCompatActivity() {


   lateinit var img : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)
        getincommingextra()

        denom.setOnClickListener {

            var intent = Intent()
            intent.setClass(this, EActivity::class.java)
            intent.putExtra("nom", denom.text)
            intent.putExtra("cv", img)
            startActivity(intent)

        }
    }



    private fun getincommingextra(){
        if(intent.hasExtra("intitule") && intent.hasExtra("duree")&&intent.hasExtra("enom") ){
            var titr = intent.getStringExtra("intitule")
            var autuer = intent.getStringExtra("duree")
            var resume = intent.getStringExtra("enom")
             img = intent.getStringExtra("ecv")
            setdetail(titr,autuer,resume,img)
        }

    }

    private fun setdetail(t:String,a :String, r : String ,img : String)
    {
        dintitule.text= t
        dduree.text= a
        denom.text = r
        decv.text=""
        dt.text=""


    }
}
