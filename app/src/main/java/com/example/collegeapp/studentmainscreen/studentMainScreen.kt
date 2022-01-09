package com.example.collegeapp.studentmainscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.collegeapp.AnnouncementCompletion
import com.example.collegeapp.R
import com.example.collegeapp.ui.dashboard.DashboardFragment
import com.example.collegeapp.unirollClass
import com.example.collegeapp.usermode
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.auth.FirebaseAuth
import fragments.Announcement
import fragments.Profile
import fragments.Result

class studentMainScreen : AppCompatActivity() {

    lateinit var studentBottomNavigation: BottomNavigationView

    val announcementfrag = Announcement()
    val resultfrag = Result()
    val profilefrag = Profile()
    lateinit var universityroll: String
    lateinit var mFragment: Fragment
    lateinit var mFragmentTransaction: FragmentTransaction
    lateinit var mBundle: Bundle
    //lateinit var toolbar: androidx.appcompat.widget.Toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_main_screen)

        universityroll = intent.getStringExtra("universityrollnum").toString()


        unirollClass.getinstance().setItem(universityroll)

        //  Toast.makeText(applicationContext, "University Roll Number->  $universityroll", Toast.LENGTH_SHORT).show()
        val mFragmentManager = supportFragmentManager
        mFragmentTransaction = mFragmentManager.beginTransaction()
        mFragment = Profile()
       //  mBundle = Bundle()
        //  mBundle.putString("Uniroll",universityroll)
      //  mFragment.arguments = mBundle
      //  Toast.makeText(applicationContext, "bundle in class", Toast.LENGTH_SHORT).show()
        mFragmentTransaction.add(R.id.fragmentcontainer, mFragment).commit()

        studentBottomNavigation = findViewById(R.id.studentBottomnavigation)
        //toolbar=findViewById(R.id.toolbar3)
        replaceFragment(profilefrag)
       // profilefrag.getInstance(universityroll)
       // setSupportActionBar(toolbar)
        studentBottomNavigation.setOnItemSelectedListener {


            when (it.itemId) {
                R.id.announcement -> {
                    replaceFragment(announcementfrag)


                }
                R.id.Result -> {
                    replaceFragment(resultfrag)

                }
                R.id.Profile -> {
                    //  mFragment.arguments = mBundle
                        replaceFragment(profilefrag)
                        //Toast.makeText(applicationContext, "passing bundle-> ${mBundle.getString("Uniroll")}", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
            studentBottomNavigation.setOnItemReselectedListener { object : NavigationBarView.OnItemReselectedListener{
                override fun onNavigationItemReselected(item: MenuItem) {
                    Toast.makeText(applicationContext, item.itemId.toString()+"reselected", Toast.LENGTH_SHORT).show()

                }


            } }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuforstudentfragments,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sign_out->{
                FirebaseAuth.getInstance().signOut()
                val intent=Intent(this,usermode::class.java)
                Toast.makeText(applicationContext, "Successfully signed out", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
        }

        return true
    }

    fun replaceFragment(fragment: Fragment)     //will change out the fragments on the basis of the button which is clicked
    {
        // Toast.makeText(applicationContext, "${mBundle.getString("Uniroll")}", Toast.LENGTH_SHORT).show()
        if (fragment != null) {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentcontainer, fragment)
            transaction.commit()
        }
    }
}

