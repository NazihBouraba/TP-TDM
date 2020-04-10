package com.example.exo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list =ArrayList<Seance>()
        list.add( Seance(Enseignant("nom1","cv1"),"4 h","TDM1"))
        list.add( Seance(Enseignant("nom2","cv2"),"3h","TDM2"))
        list.add( Seance(Enseignant("nom3","cv3"),"2h","TDM3"))
        list.add( Seance(Enseignant("nom4","cv4"),"1h","TDM4"))
        list.add( Seance(Enseignant("nom5","cv5"),"5h","TDM5"))
        list.add( Seance(Enseignant("nom6","cv6"),"3.30h","TDM6"))
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = SeanceAdapter(list,this)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

    }
}
