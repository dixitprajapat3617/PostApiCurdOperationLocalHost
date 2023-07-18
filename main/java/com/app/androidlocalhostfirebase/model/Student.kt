package com.app.androidlocalhostfirebase.model

import com.google.gson.annotations.SerializedName

data class Student(

    var id:String,
    var name:String,
    var email:String,

    var mobile:String

){
    override fun toString(): String {
        return name

    }
}
