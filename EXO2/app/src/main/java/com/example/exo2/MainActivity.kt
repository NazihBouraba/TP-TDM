package com.example.exo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listlivre =ArrayList<Livre>()
        listlivre.add( Livre("titre1","resumé du livre 1",R.mipmap.ic_launcher,"auteur 1"))
        listlivre.add( Livre("titre2","resumé du livre 2",R.mipmap.ic_launcher,"auteur 2"))
        listlivre.add( Livre("titre3","resumé du livre 3",R.mipmap.ic_launcher,"auteur 3"))
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter = LivreAdapter(listlivre,this)
        recyclerView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))

    }

}
