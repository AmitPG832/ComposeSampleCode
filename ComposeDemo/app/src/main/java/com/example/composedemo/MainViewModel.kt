package com.example.composedemo

import androidx.lifecycle.ViewModel
import com.example.composedemo.data.DetailList

class MainViewModel : ViewModel() {

    inline fun<reified T> insert( list : List<DetailList>) : List<T>{

       return list.filterIsInstance<T>()

    }


    fun DetailList(): List<Any> {
        var list =  listOf(
            DetailList.Movies("",""),
            DetailList.WebSeries("",1),
            DetailList.Serial("",3,"")
        )
        return list
    }
}