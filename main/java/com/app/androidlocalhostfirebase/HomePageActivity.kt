package com.app.androidlocalhostfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.app.androidlocalhostfirebase.databinding.ActivityHomePageBinding
import com.app.androidlocalhostfirebase.model.Student
import com.app.androidlocalhostfirebase.model.StudentListResponse
import com.app.androidlocalhostfirebase.model.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePageActivity : AppCompatActivity() {
    lateinit var adapter:ArrayAdapter<Student>
    lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        studentLoad()



    }

    private fun studentLoad() {
        ApiClient.init().getStudentList(4).enqueue(object :Callback<StudentListResponse>{
            override fun onResponse(
                call: Call<StudentListResponse>,
                response: Response<StudentListResponse>
            ) {
                if (response.isSuccessful){
                    var res=response.body()
                    res?.let {
                        adapter=ArrayAdapter(
                            applicationContext,android.R.layout.simple_list_item_1,
                            it.userlist
                        )
                        binding.listView.adapter=adapter
                    }

                }
            }

            override fun onFailure(call: Call<StudentListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}