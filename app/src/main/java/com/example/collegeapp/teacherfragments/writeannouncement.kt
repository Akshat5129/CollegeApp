package com.example.collegeapp.teacherfragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.collegeapp.R
import com.example.collegeapp.modelclass_for_Announcement
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [writeannouncement.newInstance] factory method to
 * create an instance of this fragment.
 */
class writeannouncement : Fragment() {
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


    lateinit var announcementimage:ImageView
    var uriofannouncementimage:Uri?=null
    lateinit var database: FirebaseDatabase
    lateinit var auth: FirebaseAuth
    lateinit var reference: DatabaseReference
    lateinit var submit:Button
    lateinit var headingtext:EditText
    lateinit var infoparagraph:EditText
    lateinit var storage:FirebaseStorage
    lateinit var downloadeduri:String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_writeannouncement, container, false)


        headingtext=view.findViewById<EditText>(R.id.writeannouncementheading)
        announcementimage=view.findViewById<ImageView>(R.id.announcementimage)
        infoparagraph=view.findViewById<EditText>(R.id.writeinfoannouncement)
        val addImageButton:FloatingActionButton=view.findViewById(R.id.addannouncementimage)
        submit=view.findViewById(R.id.announcebutton)
        announcementimage.setImageResource(R.drawable.avantikauniversitylogo1)


        auth= FirebaseAuth.getInstance()
        database= FirebaseDatabase.getInstance()
        storage= FirebaseStorage.getInstance()




        addImageButton.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                addImageForAnnouncement()
            }
        })


        submit.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {

                if(headingtext==null)
                {
                    Toast.makeText(context, "Please write a heading", Toast.LENGTH_SHORT).show()
                }
                else if (infoparagraph==null)
                {
                    Toast.makeText(context, "Write some information about the announcement", Toast.LENGTH_SHORT).show()
                }
                else if(uriofannouncementimage==null)
                {
                    Toast.makeText(context, "Add an image to the announcement", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    submitannouncement()
                }
            }

        })

        return view
    }



    fun addImageForAnnouncement()
    {
        ImagePicker.with(this)
            .crop()	   			//Crop image(Optional), Check Customization for more option
            .compress(1024)			//Final image size will be less than 1 MB(Optional)
            .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
            .start()
    }





    fun submitannouncement()
    {
        val range: IntRange =1..1000
        val heading:String?=headingtext.text.toString()
        val information:String?=infoparagraph.text.toString()
        val sreference=storage.reference.child(heading!!+range.random().toString())

       /* Toast.makeText(context, uriofannouncementimage.toString(), Toast.LENGTH_SHORT).show()*/
        if(uriofannouncementimage!=null)
        {
            //Toast.makeText(context, "inside not null", Toast.LENGTH_SHORT).show()
            sreference.putFile(uriofannouncementimage!!).addOnSuccessListener {

                sreference.downloadUrl.addOnSuccessListener {

                    downloadeduri=it.toString()
                    try {

                        //   Toast.makeText(context, "image uploaded", Toast.LENGTH_SHORT).show()
                        val data = modelclass_for_Announcement(downloadeduri, heading, information)
                        database.reference.child("Announcements").push().setValue(data).addOnSuccessListener {

                            Toast.makeText(context, "Announcement Made!", Toast.LENGTH_SHORT).show()
                        }

                         }

                    catch (ex:Exception)
                    {
                        Toast.makeText(context, "Exception caugght", Toast.LENGTH_SHORT).show()
                    }




                }.addOnFailureListener {
                    Toast.makeText(context, "Ex1--> "+it.toString(), Toast.LENGTH_LONG).show()
                }

            }.addOnFailureListener(){
                Toast.makeText(context, "Ex--> "+it.toString(), Toast.LENGTH_LONG).show()
            }





        }

       // Toast.makeText(context, heading+information, Toast.LENGTH_SHORT).show()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            //Image Uri will not be null for RESULT_OK
            val uri: Uri = data?.data!!
            announcementimage.setImageURI(uri)
            uriofannouncementimage=uri
            Toast.makeText(context, "Image added", Toast.LENGTH_SHORT).show()

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Cancelled", Toast.LENGTH_SHORT).show()
        }
    }






    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment writeannouncement.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            writeannouncement().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}