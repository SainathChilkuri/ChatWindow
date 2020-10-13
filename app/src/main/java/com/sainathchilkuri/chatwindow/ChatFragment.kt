package com.sainathchilkuri.chatwindow

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_chat.*

class ChatFragment: Fragment() {
    var recyclerView:RecyclerView?=null
    var recyclerView_2:RecyclerView?=null
    var list1:ArrayList<ArrayList<Chats>>?=null
    var list2:ArrayList<String>?=null
    var user:Int=0

    var count:Int = 0
    var MSG:String ? = null
    var chatlist: ArrayList<Chats> = arrayListOf()
    var mActivity:Activity?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat,container,false)
        recyclerView = view.findViewById(R.id.recyclerview)


        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity=context as Activity
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mActivity = activity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       /* var bundle =Bundle()
        bundle = arguments!!
         MSG = bundle.getString("Send")
         user = bundle.getInt("user")
        //list2 = bundle.getStringArrayList("Sender2")
        Log.d("Main","$MSG $user")*/
       // List2 = bundle.getStringArrayList("Sender2") as ArrayList<String>
       chatlist = Data.Retrieve.getData()!!

        Log.d("Main","${chatlist.size}")


        recyclerView?.adapter =CustomAdapter(mActivity as Context,chatlist)
        recyclerView?.layoutManager = LinearLayoutManager(mActivity as Context)




    }

}

