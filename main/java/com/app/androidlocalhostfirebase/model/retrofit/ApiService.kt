package com.app.androidlocalhostfirebase.model.retrofit

import com.app.androidlocalhostfirebase.model.StudentListResponse
import com.app.androidlocalhostfirebase.model.StudentResponse
import retrofit2.Call

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
        @FormUrlEncoded
        @POST("student.php")
        fun createAccont(

            @Field("flag") flag:Int,
            @Field("name") name:String,
            @Field("email") email:String,
            @Field("mobile") mobile:String
        ):Call<StudentResponse>

        @GET("student.php")
        fun getStudentList(
            @Query("flag") flag: Int
        ):Call<StudentListResponse>
}