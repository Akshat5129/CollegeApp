package com.example.collegeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import read_announcement.reading
import java.lang.Exception

class student_announcement_adpater(val list1:ArrayList<modelclass_for_Announcement>,val context:Context): RecyclerView.Adapter<student_announcement_adpater.UserDefinedViewHolder>() {

lateinit var list: MutableList<modelclass_for_Announcement>

init {

    list=list1.toMutableList().asReversed()
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDefinedViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.adapterforannouncement,parent,false)
        return UserDefinedViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserDefinedViewHolder, position: Int) {



        try {

            val heading= list[position]?.heading
            val info=list[position]?.information
            val image=list[position]?.linkofimage


                holder.heading.text = heading
                holder.infotext.text= info
                Glide.with(context).load(image).into(holder.image);
               holder.cardview.setOnClickListener(object: View.OnClickListener{
                   override fun onClick(v: View?) {
                    //   Toast.makeText(context, "onclick", Toast.LENGTH_SHORT).show()
                       val intent=Intent(context,reading::class.java)
                       intent.putExtra("heading",heading)
                       intent.putExtra("information",info)
                       intent.putExtra("Image",image)
                     //  Toast.makeText(context, "onclick2", Toast.LENGTH_SHORT).show()
                       context.startActivity(intent)
                   }


               })


        }
        catch (ex: Exception)
        {
            Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }



    class UserDefinedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val image=itemView.findViewById<ImageView>(R.id.imageannouncement)
        val heading=itemView.findViewById<TextView>(R.id.Heading_announcement)
        val cardview=itemView.findViewById<CardView>(R.id.cardviewforadapter)
        val infotext=itemView.findViewById<TextView>(R.id.info_announcement)

    }

}