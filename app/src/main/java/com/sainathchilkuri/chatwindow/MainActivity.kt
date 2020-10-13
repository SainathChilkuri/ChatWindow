package com.sainathchilkuri.chatwindow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
     var senderList:ArrayList<String> = arrayListOf()
     var senderList2:ArrayList<String> = arrayListOf()
     var chats = ArrayList<Chats>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send1.setOnClickListener{
            var msg1 = sender1.text.toString()
            if( msg1.isNotEmpty()){
                addFragment(msg1,1)


            }
        }
        send2.setOnClickListener {
            var msg2 =sender2.text.toString()
            if(msg2.isNotEmpty()){
               addFragment(msg2,2)

            }
        }




    }

    private fun addFragment(msg: String,user:Int) {
       val fragment = ChatFragment()
        /*var bundle = Bundle()

        Log.d("Main",msg)
        bundle.putString("Send",msg)
        bundle.putInt("user",user)*/

        Data.Retrieve.storedata(msg,user)
            //bundle.putStringArrayList("Sender2",senderList2)


       /* bundle.putString("Sender1",msg)
        bundle.putStringArrayList("Sender2",senderList2)*/
//        fragment.arguments = bundle
        Log.d("Fragment","Added")
        supportFragmentManager.beginTransaction().add(R.id.frame,fragment).commit()

    }
}