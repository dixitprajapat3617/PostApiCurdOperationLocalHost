package com.app.androidlocalhostfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.androidlocalhostfirebase.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}