package com.app.androidlocalhostfirebase.model

import com.google.gson.annotations.SerializedName

data class StudentListResponse(
    @SerializedName("student")
    var userlist:MutableList<Student>
)
