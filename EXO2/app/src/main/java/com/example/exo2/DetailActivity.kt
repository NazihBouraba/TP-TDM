package com.example.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.livre_item.*
import kotlinx.android.synthetic.main.livre_item.titre

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        getincommingextra()
    }

    private fun getincommingextra(){
        if(intent.hasExtra("titre") && intent.hasExtra("auteur")&&intent.hasExtra("resume") ){
            var titr = intent.getStringExtra("titre")
            var autuer = intent.getStringExtra("auteur")
            var resume = intent.getStringExtra("resume")
            var image = intent.getIntExtra("image",R.drawable.ic_launcher_background)
            setdetail(titr,autuer,resume,image)
        }

    }


    private fun setdetail(t:String,a :String, r : String ,img : Int)
    {
        titred.text= t
        auteur.text= a
        resume.text = r
        image.setImageResource(img)

    }

}
