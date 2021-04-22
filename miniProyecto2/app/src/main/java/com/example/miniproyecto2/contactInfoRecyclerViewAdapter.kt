package com.example.miniproyecto2

import android.icu.text.IDNA
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class contactInfoRecyclerViewAdapter():
    RecyclerView.Adapter<contactInfoRecyclerViewAdapter.ContactInfoViewHolder>(){

    var data = listOf<InfoContact>()
    lateinit var onClickListener: OnClickListener


    inner class ContactInfoViewHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bindView(item: InfoContact){
            var nameTextView: TextView = view.findViewById(R.id.contact_name_textview)
            var phoneTextView: TextView = view.findViewById(R.id.contact_phone_textview)
            nameTextView.text = item.name
            phoneTextView.text = item.phoneNumber
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_info_viewholder,parent, false)
        return ContactInfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ContactInfoViewHolder, position: Int) {
        val item = data[position]
        holder.bindView(item)
    }


    fun set(info: List<InfoContact>){
        data = info
        this.notifyDataSetChanged()
    }

}



