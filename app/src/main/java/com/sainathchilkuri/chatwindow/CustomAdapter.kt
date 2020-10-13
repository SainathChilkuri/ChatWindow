package com.sainathchilkuri.chatwindow

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.VisibleForTesting
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class CustomAdapter(context: Context,var chatlist:ArrayList<Chats>): RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    var context:Context?=null
    var chatlist1:ArrayList<Chats>?=null


   // var list_2:ArrayList<String> = arrayListOf()
    init {
        this.chatlist1 = chatlist
        this.context = context

    }

    inner class CustomViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var chat1: TextView?=null
        var chat2: TextView?=null
        init {
            chat1 = itemView.findViewById(R.id.sender1)
            chat2 = itemView.findViewById(R.id.sender2)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_layout,parent,false)
        return CustomViewHolder(view)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        var i =position
        if(chatlist1!![i].user == 1){
            holder.chat1?.visibility = View.VISIBLE
            Log.d("Main", " hello ${chatlist1?.size}")
            holder.chat1?.text =chatlist1!![i].sendMessage

        }
        if(chatlist1!![i].user == 2){
            holder.chat2?.visibility = View.VISIBLE
            holder.chat2?.text = chatlist1!![i].sendMessage

        }


    }

    override fun getItemCount(): Int {
        return chatlist!!.size

    }
}