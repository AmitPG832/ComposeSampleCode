package com.example.composedemo.data

sealed class DetailList {

    data class Movies(val name : String, val year : String)
    data class WebSeries(val name : String, val noOfSeries : Int)
    data class Serial(val name : String, val totlaEpisode : Int, val year : String)
}