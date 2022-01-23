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
        findViewById<Button>(R.id.button2).setOnClickListener { _ -> val inte = Intent(this, Auth::class.java)
            inte.putExtra("fragment", "login")
            startActivity(inte)}
        findViewById<Button>(R.id.button).setOnClickListener { _ -> val inte = Intent(this, Auth::class.java)
            inte.putExtra("fragment", "reg")
            startActivity(inte)}
        actionBar?.hide()
        supportActionBar?.hide()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}