package com.example.collegeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.collegeapp.studentmainscreen.studentMainScreen
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class signinActivityStudent : AppCompatActivity() {

    lateinit var auth:FirebaseAuth
    lateinit var email:TextInputEditText
    lateinit var password:EditText
    lateinit var universityroll:EditText
    lateinit var signin:Button



    private val watchText= object: TextWatcher {                   //is used for checking the conditions required to match the edt are fulfilled or not
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var Emailstudent:String?
            var passwordstudent:String?


            Emailstudent=email.text.toString().trim()
            passwordstudent=password.text.toString().trim()

            //   Toast.makeText(applicationContext, Rollnum+dateofjoin+sem+btechstream, Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext, "${userstring}  $emailstring  $passwordstring", Toast.LENGTH_SHORT).show()
            if(!Emailstudent.isEmpty() && !passwordstudent.isEmpty())
            {
                signin?.isEnabled=true
            }
            else
            {
                signin?.isEnabled=false
            }

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin_student)
        email=findViewById(R.id.email_teacher_signin)
        password=findViewById(R.id.password_teacher_signin)
        signin=findViewById(R.id.buttonsignin_student)
        universityroll=findViewById(R.id.editTextNumber2)
        auth= FirebaseAuth.getInstance()

        email.addTextChangedListener(watchText)
        password.addTextChangedListener(watchText)
        universityroll.addTextChangedListener(watchText)





    }


    fun studentsignUp(view: View)
    {
        val intent= Intent(this,studentLoginSignupmode::class.java)
        startActivity(intent)
        finish()
    }


    fun Signinstudent(view:View)
    {
        val studentemail=email.text.toString()
        val studentpassword=password.text.toString()
        val universitynum=universityroll.text.toString()

        auth.signInWithEmailAndPassword(studentemail,studentpassword).addOnSuccessListener {
            val user=auth.currentUser
            if(user!!.isEmailVerified)
            {
                val intent=Intent(this,studentMainScreen::class.java)
                intent.putExtra("universityrollnum",universitynum)

                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(applicationContext, "Email not verified", Toast.LENGTH_SHORT).show()
            }
        }
    }

}