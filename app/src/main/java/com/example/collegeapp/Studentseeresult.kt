package com.example.collegeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.collegeapp.all_semesters.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class Studentseeresult : AppCompatActivity() {

    val uniroll=unirollClass.instance.univeroll
    lateinit var checked:String
    lateinit var semester:String
    lateinit var subject1: TextView
    lateinit var subject2: TextView
    lateinit var subject3: TextView
    lateinit var subject4: TextView
    lateinit var subject5: TextView
    lateinit var subject6: TextView
    lateinit var subject7: TextView
    lateinit var subject8: TextView
    lateinit var subject9: TextView
    lateinit var subject10: TextView
    lateinit var universitynumber:TextView
    lateinit var semnumber:TextView

    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    lateinit var reference: DatabaseReference
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentseeresult)
        checked= intent.getStringExtra("midend").toString()
        semester=intent.getStringExtra("semester").toString()
      //  Toast.makeText(applicationContext, "$uniroll  $checked   $semester", Toast.LENGTH_SHORT).show()



        subject1=findViewById(R.id.studentseeresult1)
        subject2=findViewById(R.id.studentseeresult2)
        subject3=findViewById(R.id.studentseeresult3)
        subject4=findViewById(R.id.studentseeresult4)
        subject5=findViewById(R.id.studentseeresult5)
        subject6=findViewById(R.id.studentseeresult6)
        subject7=findViewById(R.id.studentseeresult7)
        subject8=findViewById(R.id.studentseeresult8)
        subject9=findViewById(R.id.studentseeresult9)
        subject10=findViewById(R.id.studentseeresult10)
        universitynumber=findViewById(R.id.univerity_rollinseeresult_)
        semnumber=findViewById(R.id.semester_number)





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


        database= FirebaseDatabase.getInstance()
        auth= FirebaseAuth.getInstance()
        reference=database.getReference()
 //       var whichsemester:Any

        semnumber.text="Semester:   "+semester
        universitynumber.text="University Roll Number:  "+uniroll

        reference.child("Users").child(uniroll!!).child("result").child(semester).child(checked)
            .addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists())
                    {
                     //   Toast.makeText(applicationContext, "Reading the data", Toast.LENGTH_SHORT).show()
                        when(semester)
                        {
                            "I"->{
                              var  whichsemester= snapshot.getValue<first>()!!
                                subject1.text=("${sem1[0]}:    ${whichsemester.basic_Electrical_Engineering}")
                                subject2.text=("${sem1[1]}:    ${whichsemester.basic_Electrical_Engineering_Lab}")
                                subject3.text=("${sem1[2]}:    ${whichsemester.career_Exellence}")
                                subject4.text=("${sem1[3]}:    ${whichsemester.computer_LabI}")
                                subject5.text=("${sem1[4]}:    ${whichsemester.engineering_MathematicsI}")
                                subject6.text=("${sem1[5]}:    ${whichsemester.engineering_Physics}")
                                subject7.text=("${sem1[6]}:    ${whichsemester.fundamental_of_Computer_and_Introduction_to_Programming}")
                                subject8.text=("${sem1[7]}:    ${whichsemester.general_Proficiency}")
                                subject9.text=("${sem1[8]}:    ${whichsemester.healthy_Living_and_Fitness}")
                                subject10.text=("${sem1[9]}:    ${whichsemester.language_Lab}")

                                /*("Basic Electrical Engineering","Basic Electrical Engineering Lab","Career Exellence","Computer Lab-I",
            "Engineering Mathematics-I","Engineering Physics","Fundamental of Computer & Introduction to Programming","General Proficiency",
            "Healthy Living and Fitness","Language Lab")*/

                            }
                            "II"->{
                               var whichsemester= snapshot.getValue<second>()!!
                                subject1.text=("${sem2[0]}:     ${whichsemester.basic_Electronics_Engineering}")
                                subject2.text=("${sem2[1]}:     ${whichsemester.basic_Electronics_Engineering_Lab}")
                                subject3.text=("${sem2[2]}:     ${whichsemester.chemistry_Lab}")
                                subject4.text=("${sem2[3]}:     ${whichsemester.computer_LabI}")
                                subject5.text=("${sem2[4]}:     ${whichsemester.engineering_Chemistry}")
                                subject6.text=("${sem2[5]}:     ${whichsemester.engineering_Graphics_and_Design_Lab}")
                                subject7.text=("${sem2[6]}:     ${whichsemester.engineering_MathematicsII}")
                                subject8.text=("${sem2[7]}:     ${whichsemester.environmental_Science}")
                                subject9.text=("${sem2[8]}:     ${whichsemester.fundamental_of_Computer_and_Introduction_to_Programming}")
                                subject10.text=("${sem2[9]}:    ${whichsemester.language_Lab}")
                            /*("Basic Electronics Engineering","Basic Electronics Engineering Lab","Chemistry Lab","Computer Lab-I",
            "Engineering Chemistry","Engineering Graphics and Design Lab","Engineering Mathematics-II",
            "Environmental Science","Fundamental of Computer & Introduction to Programming"
            ,"Language Lab")*/


                            }
                            "III"->{
                               // subject.text="${sem3[]}:   ${whichsemester}"
                                var whichsemester= snapshot.getValue<third>()!!
                                subject1.text="${sem3[0]}:      ${whichsemester.career_Skills_Lab}"
                                subject2.text="${sem3[1]}:      ${whichsemester.career_Skills}"
                                subject3.text="${sem3[2]}:      ${whichsemester.data_Structures_Lab}"
                                subject4.text="${sem3[3]}:      ${whichsemester.discrete_Structures_and_Combinatorics}"
                                subject5.text="${sem3[4]}:      ${whichsemester.fundamental_of_Cloud_Computing_Bigdata}"
                                subject6.text="${sem3[5]}:      ${whichsemester.general_Proficiency}"
                                subject7.text="${sem3[6]}:      ${whichsemester.logic_Design}"
                                subject8.text="${sem3[7]}:      ${whichsemester.logic_Design_Lab}"
                                subject9.text="${sem3[8]}:      ${whichsemester.mini_Project}"
                                subject10.text="${sem3[9]}:     ${whichsemester.moocs_Seminar}"
                                /*("Career Skills Lab","Career Skills","Data Structures Lab",
        "Discrete Structures and Combinatorics","Fundamental of Cloud Computing & Bigdata",
        "General Proficiency","Logic Design","Logic Design Lab","Mini Project"
        ,"MOOCS Seminar")*/

                            }
                            "IV"->{
                                var whichsemester= snapshot.getValue<four>()!!
                                subject1.text="${sem4[0]}:      ${whichsemester.microprocessors_Lab}"
                                subject2.text="${sem4[1]}:      ${whichsemester.java_Programming_Lab}"
                                subject3.text="${sem4[2]}:      ${whichsemester.cbnst_Lab}"
                                subject4.text="${sem4[3]}:      ${whichsemester.finite_Automata_and_Formal_Languages}"
                                subject5.text="${sem4[4]}:      ${whichsemester.microprocessors}"
                                subject6.text="${sem4[5]}:      ${whichsemester.computer_Organization}"
                                subject7.text="${sem4[6]}:      ${whichsemester.java_Programming_Language}"
                                subject8.text="${sem4[7]}:      ${whichsemester.fundamental_of_Statistics_and_AI}"
                                subject9.text="${sem4[8]}:      ${whichsemester.computer_Based_Numerical_Statistical_Technique}"
                                subject10.text="${sem4[9]}:     ${whichsemester.career_Skills}"
/*     "Microprocessors Lab"
,"Java Programming Lab","CBNST Lab","Finite Automata and Formal Languages","Microprocessors"," Computer Organization"
            ," JAVA Programming Language"," Fundamental of Statistics and AI","Computer Based Numerical & Statistical Technique","Career Skills")*/

                            }
                            else->{
                                var whichsemester= snapshot.getValue<five>()!!
                                subject1.text="${sem5[0]}:      ${whichsemester.career_Skills}"
                                subject2.text="${sem5[1]}:      ${whichsemester.career_Skills_Lab}"
                                subject3.text="${sem5[2]}:      ${whichsemester.computer_system_security}"
                                subject4.text="${sem5[3]}:      ${whichsemester.database_Management_System}"
                                subject5.text="${sem5[4]}:      ${whichsemester.dbms_Lab}"
                                subject6.text="${sem5[5]}:      ${whichsemester.design_analysis_of_Algorithm_Lab}"
                                subject7.text="${sem5[6]}:      ${whichsemester.design_and_Analysis_of_Algorithms}"
                                subject8.text="${sem5[7]}:      ${whichsemester.operating_Systems}"
                                subject9.text="${sem5[8]}:      ${whichsemester.operating_Systems_Lab}"
                                subject10.text="${sem5[9]}:     ${whichsemester.system_Software}"
                                /* "  Career Skills", "Career Skills Lab", "Computer system security", "Database Management System", "DBMS Lab",
            "Design & analysis of Algorithm Lab", "Design and Analysis of Algorithms", "Operating Systems", "Operating Systems Lab", "System Software")*/

                            }
                        }

                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })


    }
}