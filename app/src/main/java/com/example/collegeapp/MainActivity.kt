package com.example.collegeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        var handler: Handler
        handler= Handler()
        handler.postDelayed({
            intent= Intent(this,usermode::class.java)
            startActivity(intent)
            finish()
        },2000)

    }
}