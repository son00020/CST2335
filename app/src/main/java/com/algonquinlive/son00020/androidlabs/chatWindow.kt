package com.algonquinlive.son00020.androidlabs

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*

class chatWindow : Activity() {
    var messages = ArrayList<String>() //automatically grows

    var myList = null as ListView?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_window)

        var myListg = findViewById<ListView>(R.id.listView)
        var messageText = findViewById<EditText>(R.id.messageText)
        var sendButton = findViewById<Button>(R.id.sendButton)
        var myAdapter = MyAdapter(this)

    sendButton.setOnClickListener({

        var userTyped = messageText.getText().toString()
        messages.add(userTyped)
        messageText.setText("");
        myAdapter.notifyDataSetChanged()//reload the list
        val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(sendButton.getWindowToken(), 0)
            myList?.setAdapter( myAdapter)
    })
    }
inner class MyAdapter(ctx:Context) : ArrayAdapter<String>(ctx,0) {
    override fun getCount(): Int {
        return messages.size
    }

    override fun getItem(position: Int): String? {
        return messages.get(position)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var inflater = LayoutInflater.from(parent.getContext())
        var result = null as View?

        if(position % 2 == 0)
            result =inflater.inflate(R.layout.chat_row_outgoing, null)
        else
            result =inflater.inflate(R.layout.chat_row_incoming, null)

        val thisText = result.findViewById( R.id.messageText )  as TextView
        thisText.setText ( getItem(position))

        return result
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
}
}
