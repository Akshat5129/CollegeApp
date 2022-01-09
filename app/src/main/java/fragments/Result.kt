package fragments

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.collegeapp.R
import com.example.collegeapp.Studentseeresult
import com.example.collegeapp.WritingResultTeacher
import java.lang.Exception
import java.util.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Result.newInstance] factory method to
 * create an instance of this fragment.
 */
class Result : Fragment() {
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
    lateinit var progessdialog: ProgressDialog
    lateinit var midsem: RadioButton
    lateinit var endsem: RadioButton
    lateinit var spinner: Spinner
    lateinit var array: ArrayList<String>
    lateinit var semesterselected:String
    lateinit var seeresult:Button
    lateinit var checked:String


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view= inflater.inflate(R.layout.fragment_result, container, false)
        midsem=view.findViewById(R.id.studentmid_semResult)
        endsem=view.findViewById(R.id.studentend_semResult)
        spinner=view.findViewById(R.id.spinner)
        seeresult=view.findViewById(R.id.see_resultbutton)

        array = ArrayList()
        array.add("I")
        array.add("II")
        array.add("III")
        array.add("IV")
        array.add("V")

        val arrayAdapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, array)

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //set action listener
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {    //added view:View? to remove error
                semesterselected = array[position]
               // Toast.makeText(context, array[position] + " is selected ", Toast.LENGTH_SHORT).show()

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }


        seeresult.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {


                if(midsem.isChecked)
                {
                    checked="midsem"
                }
                if(endsem.isChecked)
                {
                    checked="endsem"
                }

                if(!midsem.isChecked && !endsem.isChecked)
                {
                    Toast.makeText(context, "Select Mid or End to see result", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    val intent= Intent(context, Studentseeresult::class.java)
                    intent.putExtra("semester",semesterselected)
                    intent.putExtra("midend",checked)
                    startActivity(intent)
                    // Toast.makeText(context, "Writing something", Toast.LENGTH_SHORT).show()
                }


            }

        })

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Result.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Result().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}