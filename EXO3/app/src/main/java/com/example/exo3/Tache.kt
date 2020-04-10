package com.example.exo3

import java.io.Serializable
import java.util.*

class Tache(s: String,t : String,d : Calendar) : Serializable{
    var tache =s
    var titre =t
    var date = d
}