package com.example.exo2

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.livre_item.view.*
import android.content.Intent as Intent

class LivreAdapter(ls : ArrayList<Livre>, cont : Context) : RecyclerView.Adapter<ViewHolder>() {

    var context = cont
    var listelivre = ls
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // the form of a single item
        val layoutInflater = LayoutInflater.from(parent?.context)
        val item = layoutInflater.inflate(R.layout.livre_item, parent, false)
        return ViewHolder(item)
    }

    override fun getItemCount(): Int {
        return listelivre.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.couverture.setImageResource(listelivre[position].img)
        holder.itemView.titre.text = listelivre[position].titre


        holder.itemView.setOnClickListener {
            if (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                var intent = Intent()
                intent.setClass(context, DetailActivity::class.java)
                intent.putExtra("titre", listelivre[position].titre)
                intent.putExtra("auteur", listelivre[position].auther)
                intent.putExtra("resume", listelivre[position].resume)
                intent.putExtra("image", listelivre[position].img)
                context.startActivity(intent)
             }else
            {if(context.resources.configuration.orientation== Configuration.ORIENTATION_LANDSCAPE){

                var img: ImageView = (context as MainActivity).findViewById(R.id.i) as ImageView
                img.setImageResource(listelivre[position].img)

                var t: TextView = (context as MainActivity).findViewById(R.id.t) as TextView
                t.text=listelivre[position].titre


                var a: TextView = (context as MainActivity).findViewById(R.id.a) as TextView
                a.text=listelivre[position].auther

                var r: TextView = (context as MainActivity).findViewById(R.id.r) as TextView
                r.text=listelivre[position].resume


            }
             }

            }

        }
    }
