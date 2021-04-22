package com.example.miniproyecto2

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.InputStreamReader

class ContactInfoViewModel(application: Application): AndroidViewModel(application){
    private val contactList :MutableList<InfoContact> = mutableListOf<InfoContact>()
    val myContact = MutableLiveData<MutableList<InfoContact>>()



    init{
        try {
            val filename = "contact_info.txt"
            val fileObj = application.baseContext.openFileInput(filename)
            val fileReader = InputStreamReader(fileObj)
            var text: String? = null
            while ({text = BufferedReader(fileReader).readLine()}()!= null){

                if(text != null){
                    val result = text!!.split(";")!!.toTypedArray()
                    contactList.add(InfoContact(name = result[0], phoneNumber = result[1]))
                }
            }
            myContact.postValue(contactList)
        }
        catch (e: Exception){
            Log.e("FileNotFound", "[!]ERROR ~File not found")
        }

    }

    fun addContact(contact: InfoContact){
        contactList.add(contact)
        myContact.postValue(contactList)
    }
}