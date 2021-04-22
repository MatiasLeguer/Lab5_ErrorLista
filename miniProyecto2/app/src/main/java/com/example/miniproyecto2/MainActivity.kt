package com.example.miniproyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ICommunicator{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FirstFragment>(R.id.fragment_container, "FirstFragment")
        }


    }

    override fun passData(item: Any) {
        val bundle = Bundle()
        val data = item as InfoContact
        bundle.putParcelable("DATA", data)

        this.supportFragmentManager.commit {
            val firstFragment = FirstFragment()
            firstFragment.arguments = bundle
            this.replace(R.id.fragment_container, firstFragment)
            this.addToBackStack(null)
        }



    }
}