package com.example.collegeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast

class usermode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usermode)



        val radiobuttonstudent=findViewById<RadioButton>(R.id.student)
        val radiobuttonteacher=findViewById<RadioButton>(R.id.radioButton2)
        val nextButton=findViewById<Button>(R.id.nextUsermode)

        nextButton.setOnClickListener(){
            if(radiobuttonstudent.isChecked)
            {

                val intent= Intent(applicationContext,studentLoginSignupmode::class.java)
                startActivity(intent)
            }
            else if(radiobuttonteacher.isChecked)
            {
               val intent= Intent(applicationContext,TeacherLoginSighupMode::class.java)

                   startActivity(intent)
            }
            else
            {
                Toast.makeText(applicationContext, "Please select an option.", Toast.LENGTH_SHORT).show()

            }

        }




    }
}