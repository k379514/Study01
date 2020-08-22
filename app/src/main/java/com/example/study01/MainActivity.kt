package com.example.study01

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sunny.setOnClickListener {
            textView.text="맑은 날"
            imageView.setImageResource(R.drawable.sunny02)
        }

        cloudy.setOnClickListener {
            textView.text="흐린 날"
            imageView.setImageResource(R.drawable.cloudy01)
        }

        rain.setOnClickListener {
            textView.text="비 오는 날"
            imageView.setImageResource(R.drawable.rainy02)
        }
    }

}