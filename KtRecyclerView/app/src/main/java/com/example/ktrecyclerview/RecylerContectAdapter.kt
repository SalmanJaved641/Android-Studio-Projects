package com.example.ktrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerContectAdapter(val context: Context,val arrContect: ArrayList<ContactModel>) : RecyclerView.Adapter<RecylerContectAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img_contect=itemView.findViewById<ImageView>(R.id.img_contect)
        val txt_number =itemView.findViewById<TextView>(R.id.txt_number)
        val txt_name =itemView.findViewById<TextView>(R.id.txt_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false))
    }

    override fun getItemCount(): Int {
        return arrContect.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.img_contect.setImageResource(arrContect[position].img)  // Assuming 'img' is an Int (drawable ID)
        holder.txt_name.text = arrContect[position].name
        holder.txt_number.text = arrContect[position].number
    }
}