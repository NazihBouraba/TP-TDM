package com.example.exo3

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_tache.*
import kotlinx.android.synthetic.main.tache.view.*
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TacheAdapter(ls : ArrayList<Tache>, cont : Context) : RecyclerView.Adapter<ViewHolder>() {


    var tl =ls
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val ite = layoutInflater.inflate(R.layout.tache, parent, false)
        return ViewHolder(ite)
    }

    override fun getItemCount(): Int {
        return tl.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.itemView.tache.text = tl[position].tache
        holder.itemView.titre.text = tl[position].titre
        val myFormat = "MM/dd/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        holder.itemView.date.text = sdf.format(tl[position].date.getTime())

        holder.itemView.setOnClickListener{

           try {
              var i = tl.indexOf(tl[position])
               tl.removeAt(i)
               notifyItemRemoved(position)
           }catch (e :Exception){}



        }


    }
}