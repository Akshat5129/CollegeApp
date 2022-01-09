package com.example.collegeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.collegeapp.all_semesters.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class WritingResultTeacher : AppCompatActivity() {

var semestersubjects= mutableListOf<MutableList<String>>()
lateinit var submitButton:Button
lateinit var edittextarray:MutableList<EditText>
lateinit var universitynum:EditText
lateinit var subject1:EditText
lateinit var subject2:EditText
lateinit var subject3:EditText
lateinit var subject4:EditText
lateinit var subject5:EditText
lateinit var subject6:EditText
lateinit var subject7:EditText
lateinit var subject8:EditText
lateinit var subject9:EditText
lateinit var subject10:EditText
lateinit var database: FirebaseDatabase
lateinit var auth: FirebaseAuth
lateinit var reference: DatabaseReference
lateinit var checked:String
lateinit var semester:String





    private val watchText= object: TextWatcher {                   //is used for checking the conditions required to match the edt are fulfilled or not
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            var one:String?
            var two:String?
            var three:String?
            var four:String?
            var five:String?
            var six:String?
            var seven:String?
            var eight:String?
            var nine:String?
            var ten:String?

            one=subject1.text.toString().trim()
            two=subject2.text.toString().trim()
            three=subject3.text.toString().trim()
            four=subject4.text.toString().trim()
            five=subject5.text.toString().trim()
            six=subject6.text.toString().trim()
            seven=subject7.text.toString().trim()
            eight=subject8.text.toString().trim()
            nine=subject9.text.toString().trim()
            ten=subject10.text.toString().trim()
            val uninum=universitynum.text.toString().trim()
            if(!one.isEmpty() && !two.isEmpty() && !three.isEmpty() && !four.isEmpty() && !five.isEmpty() && !six.isEmpty() && !seven.isEmpty()
                && !eight.isEmpty() && !nine.isEmpty() && !ten.isEmpty() &&!uninum.isEmpty())
            {
                submitButton.isEnabled=true

            }
            else
            {
                submitButton.isEnabled=false
            }



        }

        override fun afterTextChanged(s: Editable?) {

        }

    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_writing_result_teacher)

        universitynum=findViewById(R.id.university_roll_numwriting)


        subject1=findViewById(R.id.oneinresult)
        subject2=findViewById(R.id.twoinresult)
        subject3=findViewById(R.id.threeinresult)
        subject4=findViewById(R.id.fourinresult)
        subject5=findViewById(R.id.fiveinresult)
        subject6=findViewById(R.id.sixinresult)
        subject7=findViewById(R.id.seveninresult)
        subject8=findViewById(R.id.eightinresult)
        subject9=findViewById(R.id.nineinresult)
        subject10=findViewById(R.id.teninresult)

        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        reference=database.getReference()

        submitButton=findViewById(R.id.Submit_written_result)
        edittextarray= mutableListOf<EditText>(subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10)
      checked= intent.getStringExtra("midend").toString()
        semester=intent.getStringExtra("semester").toString()
        var sem1= mutableListOf<String>("Basic Electrical Engineering","Basic Electrical Engineering Lab","Career Exellence","Computer Lab-I",
            "Engineering Mathematics-I","Engineering Physics","Fundamental of Computer & Introduction to Programming","General Proficiency",
            "Healthy Living and Fitness","Language Lab")

        var sem2= mutableListOf<String>("Basic Electronics Engineering","Basic Electronics Engineering Lab","Chemistry Lab","Computer Lab-I",
            "Engineering Chemistry","Engineering Graphics and Design Lab","Engineering Mathematics-II","Environmental Science","Fundamental of Computer & Introduction to Programming"
            ,"Language Lab")
        var sem3= mutableListOf<String>("Career Skills Lab","Career Skills","Data Structures Lab",
            "Discrete Structures and Combinatorics","Fundamental of Cloud Computing & Bigdata","General Proficiency","Logic Design","Logic Design Lab","Mini Project"
            ,"MOOCS Seminar")
        var sem4= mutableListOf<String>(
            "Microprocessors Lab","Java Programming Lab","CBNST Lab","Finite Automata and Formal Languages","Microprocessors"," Computer Organization"
            ," JAVA Programming Language"," Fundamental of Statistics and AI","Computer Based Numerical & Statistical Technique","Career Skills")
        var sem5= mutableListOf<String>(
            "  Career Skills", "Career Skills Lab", "Computer system security", "Database Management System", "DBMS Lab",
            "Design & analysis of Algorithm Lab", "Design and Analysis of Algorithms", "Operating Systems", "Operating Systems Lab", "System Software")

        semestersubjects.add(sem1)
        semestersubjects.add(sem2)
        semestersubjects.add(sem3)
        semestersubjects.add(sem4)
        semestersubjects.add(sem5)


        when(semester){
            "I"->{
                for(i in 0..9)
                {
                    edittextarray[i].setHint(sem1[i])
                }

            }

            "II"->{
                for(i in 0..9)
                {
                    edittextarray[i].setHint(sem2[i])
                }
            }

            "III"->{
                for(i in 0..9)
                {
                    edittextarray[i].setHint(sem3[i])
                }



            }
            "IV"->{
                for(i in 0..9)
                {
                    edittextarray[i].setHint(sem4[i])
                }
            }

            "V"->{
                for(i in 0..9)
                {
                    edittextarray[i].setHint(sem5[i])
                }
            }
        }

       subject1.addTextChangedListener(watchText)
        subject2.addTextChangedListener(watchText)
        subject3.addTextChangedListener(watchText)
        subject4.addTextChangedListener(watchText)
        subject5.addTextChangedListener(watchText)
        subject6.addTextChangedListener(watchText)
        subject7.addTextChangedListener(watchText)
        subject8.addTextChangedListener(watchText)
        subject9.addTextChangedListener(watchText)
        subject10.addTextChangedListener(watchText)
        universitynum.addTextChangedListener(watchText)




        Toast.makeText(applicationContext, semester, Toast.LENGTH_SHORT).show()
       // Toast.makeText(applicationContext, checked, Toast.LENGTH_SHORT).show()

    }

    fun submitDataForWriting(view: View)
    {
        val one:String?
        val two:String?
        val three:String?
        val four:String?
        val five:String?
        val six:String?
        val seven:String?
        val eight:String?
        val nine:String?
        val ten:String?
        val whichsemester:Any


        one=subject1.text.toString().trim()
        two=subject2.text.toString().trim()
        three=subject3.text.toString().trim()
        four=subject4.text.toString().trim()
        five=subject5.text.toString().trim()
        six=subject6.text.toString().trim()
        seven=subject7.text.toString().trim()
        eight=subject8.text.toString().trim()
        nine=subject9.text.toString().trim()
        ten=subject10.text.toString().trim()
        when(semester)
        {
            "I"->{
                whichsemester=first(one,two,three,four,five,six,seven,eight,nine,ten)
            }
            "II"->{
                whichsemester=second(one,two,three,four,five,six,seven,eight,nine,ten)
            }
            "V"->{
                whichsemester= five(one,two,three,four,five,six,seven,eight,nine,ten)
            }
            "IV"->{
                whichsemester= four(one,two,three,four,five,six,seven,eight,nine,ten)
            }
            else->{
                whichsemester=third(one,two,three,four,five,six,seven,eight,nine,ten)
            }
        }

        database.reference.child("Users").child(universitynum.text.toString()).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(!snapshot.exists())
                {
                    Toast.makeText(applicationContext, "Does not exists", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    database.reference.child("Users").child(universitynum.text.toString()).child("result").child(semester)
                        .child(checked).setValue(whichsemester).addOnSuccessListener {

                            Toast.makeText(applicationContext, "Result Published!", Toast.LENGTH_SHORT).show()
                        }.addOnFailureListener {
                            Toast.makeText(applicationContext, it.toString(), Toast.LENGTH_SHORT).show()
                        }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }

}