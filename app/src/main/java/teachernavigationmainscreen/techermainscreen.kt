package teachernavigationmainscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.collegeapp.R
import com.example.collegeapp.teacherfragments.AnnouncementTeacher
import com.example.collegeapp.teacherfragments.writeannouncement
import com.example.collegeapp.teacherfragments.writeresult
import com.google.android.material.bottomnavigation.BottomNavigationView

class techermainscreen : AppCompatActivity() {


    lateinit var teacherbottomnavigation:BottomNavigationView
    val announcementfrag=AnnouncementTeacher()
    val writefrag=writeannouncement()
    val resfrag=writeresult()
    lateinit var mFragment: Fragment
    lateinit var mFragmentTransaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_techermainscreen)

        teacherbottomnavigation=findViewById(R.id.teacherBottomNavigation)
        val mFragmentManager = supportFragmentManager
        mFragmentTransaction = mFragmentManager.beginTransaction()
        mFragment=AnnouncementTeacher()
        mFragmentTransaction.add(R.id.fragmentcontainerforteacher, mFragment).commit()

        replaceFragment(announcementfrag)
        teacherbottomnavigation.setOnItemSelectedListener {


            when (it.itemId) {
                R.id.teacherannouncement -> {
                    replaceFragment(announcementfrag)


                }
                R.id.writeresult -> {
                    replaceFragment(resfrag)

                }
                R.id.announcesome -> {
                    //  mFragment.arguments = mBundle
                    replaceFragment(writefrag)
                    //Toast.makeText(applicationContext, "passing bundle-> ${mBundle.getString("Uniroll")}", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

    }

    fun replaceFragment(fragment: Fragment)     //will change out the fragments on the basis of the button which is clicked
    {
        // Toast.makeText(applicationContext, "${mBundle.getString("Uniroll")}", Toast.LENGTH_SHORT).show()
        if (fragment != null) {

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentcontainerforteacher, fragment)
            transaction.commit()
        }
    }

}