package com.example.jokesapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.jokesapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    // main activity binding
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getJoke()
    }

    fun nextButtonClicked(view: View) {
        getJoke()
    }

    private fun getJoke() {
        // creating the request queue
        binding.jokeTextView.text = ""
        binding.progress.visibility = View.VISIBLE
        val queue = VolleyRequestSingleton.getInstance(this.applicationContext).requestQueue

        val url = "https://v2.jokeapi.dev/joke/Any?type=single"

        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null, { response ->
            val jokeLine = response.getString("joke")
            binding.jokeTextView.text = jokeLine
            binding.progress.visibility = View.GONE
        }, {
            error -> Toast.makeText(this,error.localizedMessage,Toast.LENGTH_LONG).show()
            binding.progress.visibility = View.GONE
            Log.d("error",error.toString())
        })

        queue.add(jsonObjectRequest)
    }
}