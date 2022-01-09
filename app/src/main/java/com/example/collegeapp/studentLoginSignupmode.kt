package com.example.collegeapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import java.net.URI

class studentLoginSignupmode : AppCompatActivity() {


    lateinit var username: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var password: TextView
    lateinit var signoubutton: Button
    lateinit var studentprofilepicuploadbtton: FloatingActionButton
    lateinit var studentprofilepic: ImageView
    lateinit var auth: FirebaseAuth
    lateinit var database: FirebaseDatabase
    var ProfilepicURI:Uri? = null


    private val watchText= object: TextWatcher {                   //is used for checking the conditions required to match the edt are fulfilled or not
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var userstring:String?
            var emailstring:String?
            var passwordstring:String?

            userstring=username.text.toString().trim()
            emailstring=email.text.toString().trim()
            passwordstring=password.text.toString().trim()
            //Toast.makeText(applicationContext, "${userstring}  $emailstring  $passwordstring", Toast.LENGTH_SHORT).show()
            if(!userstring.isEmpty() && !emailstring.isEmpty() && !passwordstring.isEmpty())
            {
                signoubutton?.isEnabled=true
            }
            else
            {
                signoubutton?.isEnabled=false
            }

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_login_signupmode)


        username= findViewById<TextInputEditText>(R.id.usernametext)
        email=findViewById<TextInputEditText>(R.id.emailtext)
        password= findViewById<TextView>(R.id.passwordtext2)
        signoubutton=findViewById<Button>(R.id.sign_up)
        signoubutton.isEnabled=false
        studentprofilepicuploadbtton=findViewById(R.id.addprofileimage)
        studentprofilepic=findViewById(R.id.addprofilestudent)
        studentprofilepic.setImageResource(R.drawable.avantikauniversitylogo1)

        username.addTextChangedListener(watchText)
        email.addTextChangedListener(watchText)
        password.addTextChangedListener(watchText)


        //ProfilepicURI=Uri.parse("android.resource://your.package.name/")


        auth= FirebaseAuth.getInstance()    //we got a instance of firebase authentication
        //to check if all the text are filled before clicking on submit button

        database= FirebaseDatabase.getInstance()


    }




    fun addImageForStudent(view: View)
    {

        ImagePicker.with(this)
            .crop()	   			//Crop image(Optional), Check Customization for more option
            .compress(1024)			//Final image size will be less than 1 MB(Optional)
            .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
            .start()
    }

    //for setting the selected image to imageview
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!
            studentprofilepic.setImageURI(uri)
            ProfilepicURI=uri

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }


    fun signinStudents(view: View)    //if the user already has a account
    {
        val intent= Intent(this,signinActivityStudent::class.java)
        startActivity(intent)
        finish()
    }


    fun createNewAccount(view: View)
    {
        if(ProfilepicURI==null)
        {
            Toast.makeText(applicationContext, "Add a profile image before logging in!", Toast.LENGTH_SHORT).show()
        }
        else {
            val email: String = email.text.toString()
            val password: String = password.text.toString()
            val studentname: String = username.text.toString()

            val intent = Intent(applicationContext, studentsignupdataActivity::class.java)
            intent.putExtra("email", email)
            intent.putExtra("password", password)
            intent.putExtra("studentname", studentname)
            intent.putExtra("imageuri", ProfilepicURI.toString())
            startActivity(intent)
        }
    }



}