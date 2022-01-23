package com.example.rcs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentContainerView
import androidx.viewpager2.adapter.FragmentViewHolder

class Auth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val frament_manager = supportFragmentManager
        // frament_manager.beginTransaction().replace(R.id.fragmentContainerView, RegFragment()).addToBackStack(null).commit()
        findViewById<Button>(R.id.button3).setOnClickListener { _ -> println(supportFragmentManager.findFragmentById(R.id.fragmentContainerView) is LoginFragment) }
    }


}