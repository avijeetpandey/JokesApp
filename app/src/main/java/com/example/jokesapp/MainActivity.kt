package com.example.jokesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.jokesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // main activity binding
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
    }

    fun nextButtonClicked(view: View) {
       
    }
}