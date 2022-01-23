package com.example.rcs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<ImageButton>(R.id.imageButton).setOnClickListener{_ -> finish()}
        findViewById<Button>(R.id.button).setOnClickListener { _ -> startActivity(Intent(this, login::class.java))}

    }
}