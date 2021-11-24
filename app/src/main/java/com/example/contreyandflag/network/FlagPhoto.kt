package com.example.contreyandflag.network
data class arraylist(var error : Boolean,val msg:String,val data:List<FlagPhoto>)
data class FlagPhoto(val name:String,val flag: String)