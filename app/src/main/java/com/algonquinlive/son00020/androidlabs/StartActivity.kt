package com.algonquinlive.son00020.androidlabs

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : Activity() {
    val StartActivity  = "startActivity"

    override fun  onActivityResult( requestCode : Int, responseCode : Int ,data : Intent ) {
//    if (requestCode == 50) {
//        Log.i(StartActivity, "Returned to StartActivity.onActivityResult")
//    }


    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
      var startButton=  findViewById<Button>(R.id.StartButton2)
        startButton?.setOnClickListener {

            var intent = Intent(this, ListItemsActivity::class.java)
//
            startActivityForResult(intent,50)

        }



    }

    override fun onResume(){
        super.onResume()
        Log.i(StartActivity,"In onResume")
    }

    override fun onStart(){
        super.onStart()
        Log.i(StartActivity,"In onStart")
    }

    override fun onPause(){
        super.onPause()
        Log.i(StartActivity,"In onPuase")
    }

    override fun onStop(){
        super.onStop()
        Log.i(StartActivity,"In onStop")
    }

    override fun onDestroy(){
            super.onDestroy()
        Log.i(StartActivity,"In onDestroy")
    }





}



