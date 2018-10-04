package com.algonquinlive.son00020.androidlabs

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class LoginActivity : Activity() {
    val LOGIN_ACTIVITY = "LoginActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var loginButon = findViewById<Button>(R.id.logInButton)
        val prefs = getSharedPreferences("preferenceList",0)
        val logInText = findViewById<EditText>(R.id.LoginText)
        loginButon.setOnClickListener {

            var text = logInText.text.toString()
            val edit = prefs.edit();
            edit.putString("defaultEmail",text)
            edit.commit()


            var intent = Intent(this@LoginActivity, StartActivity::class.java)

            startActivity(intent)
        }
        var  emailDefault =  prefs.getString("defaultEmail",null)
        // put the email into the edit text

        logInText.setText(emailDefault)


    }






    override fun onResume(){
        super.onResume()
        Log.i(LOGIN_ACTIVITY,"In onResume")
    }


    override fun onStart(){
        super.onStart()
        Log.i(LOGIN_ACTIVITY,"In onStart")

    }

    override fun onPause(){
        super.onPause()
        Log.i(LOGIN_ACTIVITY,"In onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i(LOGIN_ACTIVITY,"In onStop")

    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i(LOGIN_ACTIVITY,"In onDestroy")

    }




    

}
