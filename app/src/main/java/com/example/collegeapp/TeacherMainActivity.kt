package com.example.collegeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.collegeapp.databinding.ActivityTeacherMainBinding
import com.example.collegeapp.studentmainscreen.studentMainScreen

class TeacherMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeacherMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTeacherMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_teacher_main)


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.


        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val student= intent.getStringExtra("student").toString()
        val teacher= intent.getStringExtra("teacher").toString()



        if(student.equals("true")  && teacher.equals("false"))
        {
            studentScreen()
        }

       else if(student.equals("false")  && teacher.equals("true"))
        {
            TeacherScreen()
        }


    }


    fun studentScreen()
    {
        Toast.makeText(applicationContext, "student screen", Toast.LENGTH_SHORT).show()
    }


    fun TeacherScreen()
    {
        Toast.makeText(applicationContext, "Teacher Screen", Toast.LENGTH_SHORT).show()
    }

}