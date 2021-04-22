package com.example.miniproyecto2

import android.icu.text.IDNA
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: contactInfoRecyclerViewAdapter
    private val viewModel: ContactInfoViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val btn_add = view.findViewById<Button>(R.id.btn_add_contact)

        adapter = contactInfoRecyclerViewAdapter()
        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.myContact.observe(viewLifecycleOwner, Observer {
            adapter.set(it)
        })

        val argument = this.arguments?.let {
            it.get("DATA") as InfoContact
        }

        if (argument != null){
            viewModel.addContact(argument)
        }



        btn_add.setOnClickListener {
            val contactInfoFragment = FragmentContactInfo()
            activity?.supportFragmentManager?.commit {
                this.replace(R.id.fragment_container, contactInfoFragment)
                this.addToBackStack(null)

            }
        }
        return view
    }

}