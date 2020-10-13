package com.sainathchilkuri.chatwindow

import android.util.Log

class Data {

    companion object Retrieve{
        var chats: ArrayList<Chats> = arrayListOf()
        fun storedata(msg: String, num:Int){
            Log.d("Main","DataStored")
            chats?.add(Chats(msg,num))
        }

        fun getData(): ArrayList<Chats> {
            Log.d("Main","DataStored")
            return chats!!
        }

    }
}