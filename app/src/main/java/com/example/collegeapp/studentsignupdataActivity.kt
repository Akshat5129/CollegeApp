package com.example.collegeapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.collegeapp.studentdataAttributes.studentdatasignup
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class studentsignupdataActivity : AppCompatActivity() {


    lateinit var email:String
    lateinit var password:String
    lateinit var username:String
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    lateinit var reference: DatabaseReference
    lateinit var universityRollnumber:EditText
    lateinit var dateofjoining:EditText
    lateinit var semester:EditText
    lateinit var stream:TextInputEditText
    lateinit var submit:Button
    lateinit var storage:FirebaseStorage
    lateinit var Profileimageuri:Uri
    val context:Context=this

    lateinit var studentdata:studentdatasignup


    private val watchText= object: TextWatcher {                   //is used for checking the conditions required to match the edt are fulfilled or not
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var Rollnum:String?
            var dateofjoin:String?
            var sem:String?
            var btechstream:String?

            Rollnum=universityRollnumber.text.toString().trim()
            dateofjoin=dateofjoining.text.toString().trim()
            sem=semester.text.toString().trim()
            btechstream=stream.text.toString().trim()
         //   Toast.makeText(applicationContext, Rollnum+dateofjoin+sem+btechstream, Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext, "${userstring}  $emailstring  $passwordstring", Toast.LENGTH_SHORT).show()
            if(!Rollnum.isEmpty() && !dateofjoin.isEmpty() && !sem.isEmpty() && !btechstream.isEmpty())
            {
                submit?.isEnabled=true
            }
            else
            {
                submit?.isEnabled=false
            }

        }

        override fun afterTextChanged(s: Editable?) {

        }

    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentsignupdata)
        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        reference=database.getReference()
        storage= FirebaseStorage.getInstance()


        email= intent.getStringExtra("email").toString()
        username= intent.getStringExtra("studentname").toString()
        password= intent.getStringExtra("password").toString()
        val bundle: Bundle? =intent.extras

           Profileimageuri =Uri.parse(bundle!!.getString("imageuri"))



    //    Toast.makeText(applicationContext, Profileimageuri.toString(), Toast.LENGTH_SHORT).show()

        universityRollnumber=findViewById(R.id.universityrollnumber)
        dateofjoining=findViewById(R.id.editTextDate)
        semester=findViewById(R.id.editTextNumber)
        stream=findViewById(R.id.stream)
        submit=findViewById(R.id.submitbutton)


        universityRollnumber.addTextChangedListener(watchText)
        dateofjoining.addTextChangedListener(watchText)
        semester.addTextChangedListener(watchText)
        stream.addTextChangedListener(watchText)



        //Toast.makeText(applicationContext, email+username+password, Toast.LENGTH_SHORT).show()


    }




    fun CreateUserForStudent(view: View)
    {
        Toast.makeText(applicationContext, email+password, Toast.LENGTH_SHORT).show()

        val uniroll:String=universityRollnumber.text.toString()
        val doj:String=dateofjoining.text.toString()
        val sem:String=semester.text.toString()
        val currentstream=stream.text.toString()
        var profileimagelink:String?=null

        val sreference=storage.reference.child(uniroll)
        val downreference=storage.reference

        reference.child("Users").child(uniroll).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists())
                {
                    Toast.makeText(applicationContext, "A user already exists with this university roll number", Toast.LENGTH_SHORT).show()
                }
                else
                {

                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this@studentsignupdataActivity){
                            task->
                        if(task.isSuccessful) {

                            val user: FirebaseUser? = auth.currentUser
                            user!!.sendEmailVerification().addOnSuccessListener {
                                    verify->

                                Toast.makeText(
                                    applicationContext,
                                    "Verification Email sent",
                                    Toast.LENGTH_SHORT
                                ).show()

                                if (Profileimageuri.toString() != "null") {       //in case user enters profile pic

                                    // Toast.makeText(applicationContext, "inside if block", Toast.LENGTH_SHORT).show()
                                    sreference.putFile(Profileimageuri).addOnSuccessListener {

                                        sreference.downloadUrl.addOnSuccessListener { uri ->
                                            //   Toast.makeText(applicationContext, "yes inside", Toast.LENGTH_LONG).show()
                                            studentdata = studentdatasignup(
                                                uniroll,
                                                username,
                                                email,
                                                password,
                                                doj,
                                                sem,
                                                currentstream,
                                                uri.toString()
                                            )
                                            database.reference.child("Users").child(uniroll)
                                                .setValue(studentdata)
                                                .addOnCompleteListener() {
                                                    //  Toast.makeText(applicationContext, "data entered successfully!", Toast.LENGTH_SHORT).show()

                                                }
                                            StudentSigninScreen()
                                            finish()
                                            //    Toast.makeText(applicationContext, profileimagelink, Toast.LENGTH_LONG).show()

                                        }.addOnFailureListener { exception ->
                                            Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT)
                                                .show()
                                        }
                                    }

                                } else    //in case the user does not enters a profilepic
                                {
                                    //    Toast.makeText(applicationContext, "inside else block", Toast.LENGTH_SHORT).show()
                                    studentdata = studentdatasignup(
                                        uniroll,
                                        username,
                                        email,
                                        password,
                                        doj,
                                        sem,
                                        currentstream,
                                        null
                                    )
                                    database.reference.child("Users").child(uniroll).setValue(studentdata)
                                        .addOnCompleteListener() {
                                            //  Toast.makeText(applicationContext, "data entered successfully!", Toast.LENGTH_SHORT).show()

                                        }

                                    StudentSigninScreen()
                                    finish()
                                }

                            }
                        }
                        else{
                            Toast.makeText(applicationContext,"Error: "+ task.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }


                }
            }

            override fun onCancelled(error: DatabaseError) {

            }


        })

    }



    fun StudentSigninScreen()
    {
        val intent=Intent(this,signinActivityStudent::class.java)
        startActivity(intent)
    }



    fun signIn()
    {

    }

}