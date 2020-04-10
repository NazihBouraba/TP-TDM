package com.example.exo4

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.seance.view.*

class SeanceAdapter (ls : ArrayList<Seance>, cont : Context) : RecyclerView.Adapter<ViewHolder>() {

    var listeseance = ls
    var context = cont

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val item = layoutInflater.inflate(R.layout.seance, parent, false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
     return  listeseance.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.intitule.text = listeseance[position].intitule
        holder.itemView.duree.text = listeseance[position].duree
        holder.itemView.enseignant.text = listeseance[position].enseignant.nom


        holder.itemView.setOnClickListener {
            if (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                var intent = Intent()
                intent.setClass(context, DetailActivity::class.java)
                intent.putExtra("intitule", listeseance[position].intitule)
                intent.putExtra("duree", listeseance[position].duree)
                intent.putExtra("enom", listeseance[position].enseignant.nom)
                intent.putExtra("ecv", listeseance[position].enseignant.cv)
                context.startActivity(intent)
            }else
            {if(context.resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){

                var t: TextView = (context as MainActivity).findViewById(R.id.dintitule) as TextView
                t.text=listeseance[position].intitule

                var tt = (context as MainActivity).findViewById(R.id.dduree) as TextView
                tt.text=listeseance[position].duree

                var a = (context as MainActivity).findViewById(R.id.denom) as TextView
                a.text=listeseance[position].enseignant.nom

                var b = (context as MainActivity).findViewById(R.id.decv) as TextView
                b.text=listeseance[position].enseignant.cv


            }
            }

        }
    }
}