package com.example.collegeapp.teacherfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.collegeapp.R
import com.example.collegeapp.modelclass_for_Announcement
import com.example.collegeapp.student_announcement_adpater
import com.google.firebase.database.*
import java.lang.NullPointerException

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnnouncementTeacher.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnnouncementTeacher : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_announcement_teacher, container, false)



        var recycler: RecyclerView?
        var database: FirebaseDatabase?    //gives us the reference of the complete database
        var reference: DatabaseReference?  //gives us the reference of a particular node
        var list:ArrayList<modelclass_for_Announcement>?
        var progressbar: ProgressBar?

        recycler = view.findViewById(R.id.recyclerteacher)
        database = FirebaseDatabase.getInstance()
        reference = database.reference
        list = arrayListOf()

        if (activity != null && isAdded && !isRemoving) {

            reference.child("Announcements")
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {


                        for (snap in snapshot.children) {

                            val user = snap?.getValue(modelclass_for_Announcement::class.java)
                            // val nama=snap.child("-Ms9gogs468bnOPQp59U/first").getValue(String::class.java)
                            // if (user != null) {
                            //   Toast.makeText(context,"->  "+ user?.heading, Toast.LENGTH_SHORT).show()
                            // }

                            if (user != null) {
                                list.add(user)
                                //    Toast.makeText(context, "|--> "+list[0].heading, Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "user is null", Toast.LENGTH_SHORT).show()
                            }

                        }



                        if (list.size > 0) {
                            try {
                                val adapter = student_announcement_adpater(
                                    list,
                                    context!!
                                ) //THIS WAS THE PLACE WHERE THE MAIN BUG ACTUALLY WAS RESIDING
                                recycler.layoutManager = LinearLayoutManager(
                                    context,
                                    LinearLayoutManager.VERTICAL,
                                    false
                                )
                                recycler.adapter = adapter
                            } catch (ex: NullPointerException)   //TO CATCH THAT BUG
                            {

                            }
                            //Toast.makeText(context, "adapter finished", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(context, "failed to read data", Toast.LENGTH_SHORT)
                                .show()
                        }


                    }

                    override fun onCancelled(error: DatabaseError) {
                        Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show()
                    }

                })

        }
            return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AnnouncementTeacher.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AnnouncementTeacher().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}