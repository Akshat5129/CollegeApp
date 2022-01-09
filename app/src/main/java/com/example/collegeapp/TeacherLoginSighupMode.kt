package com.example.collegeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.*
import com.example.collegeapp.studentmainscreen.studentMainScreen
import com.google.android.material.textfield.TextInputEditText

class TeacherLoginSighupMode : AppCompatActivity() {


    lateinit var adminNumber:EditText
    lateinit var password: TextView
    lateinit var signupadminmode: Button
    val strpass1:String="admin@123"
    val stradminnum1:String="1"
    val strpass2:String="admin@456"
    val stradminnum2:String="2"



    private val watchText= object: TextWatcher {                   //is used for checking the conditions required to match the edt are fulfilled or not
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var userstring:String?
            var emailstring:String?
            var passwordstring:String?

            userstring=adminNumber.text.toString().trim()
            passwordstring=password.text.toString().trim()
            //Toast.makeText(applicationContext, "${userstring}  $emailstring  $passwordstring", Toast.LENGTH_SHORT).show()
            if(!userstring.isEmpty() && !passwordstring.isEmpty())
            {
                signupadminmode?.isEnabled=true
            }
            else
            {
                signupadminmode?.isEnabled=false
            }

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher_login_sighup_mode)
        adminNumber=findViewById(R.id.admin_number)
        password=findViewById(R.id.password_teacher_signin)
        signupadminmode=findViewById(R.id.sign_in_teachers)




        adminNumber.addTextChangedListener(watchText)
        password.addTextChangedListener(watchText)


    }


    fun signInAdmin(view: View) {
        val struser:String? = adminNumber.text.toString()
        val strpass:String? = password.text.toString()
        if ((struser.equals(stradminnum1) && strpass.equals(strpass1)) || (struser.equals(stradminnum2) && strpass.equals(strpass2)))
        {
           val intent=Intent(this,teachernavigationmainscreen.techermainscreen::class.java)
            startActivity(intent)
            finish()

        } else {
            Toast.makeText(
                applicationContext,
                "incorrect admin number OR password",
                Toast.LENGTH_SHORT
            ).show()
        }

    }


}