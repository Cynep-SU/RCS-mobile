package com.example.rcs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ImageButton>(R.id.imageButton).setOnClickListener{_ -> finish()}
        findViewById<Button>(R.id.button2).setOnClickListener { _ -> startActivity(Intent(this, Auth::class.java))}
        actionBar?.hide()
        supportActionBar?.hide()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}