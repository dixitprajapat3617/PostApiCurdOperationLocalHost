package com.app.androidlocalhostfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.androidlocalhostfirebase.databinding.ActivitySignUpBinding
import com.app.androidlocalhostfirebase.model.StudentResponse
import com.app.androidlocalhostfirebase.model.retrofit.ApiClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var contact = binding.etContact.text.toString().trim()

            studentAccountCreated(name, email, contact)

        }



    }

    private fun studentAccountCreated(name:String,email:String,contact:String) {
        ApiClient.init().createAccont(1, name,email,contact).enqueue(object :Callback<StudentResponse>{
            override fun onResponse(
                call: Call<StudentResponse>,
                response: Response<StudentResponse>
            ) {
                if (response.isSuccessful){
                    var res=response.body()
                    res?.let {
                        Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
                        if (it.status=="success"){
                            var intent = Intent(applicationContext, HomePageActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<StudentResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }


}