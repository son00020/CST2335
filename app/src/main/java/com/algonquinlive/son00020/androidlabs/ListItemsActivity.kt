
package com.algonquinlive.son00020.androidlabs
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_list_items.*
import kotlin.math.log

class ListItemsActivity : Activity() {
    val LIST_ACTIVITY = "ListActivity"
    val REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_items)
        var imageButton = null as? ImageButton
        var switchButton = findViewById<Switch>(R.id.switch1)
        var checkBox = findViewById<CheckBox>(R.id.checkBox)

        imageButton = findViewById<ImageButton>(R.id.imageButton)

                imageButton?.setOnClickListener {
                    dispatchTakePictureIntent()
        }

        switchButton?.setOnCheckedChangeListener { buttonView, isChecked ->
           var text = "Switch is On" // "Switch is Off"
           if (switchButton.isChecked()) text = "Switch is on"
           else
               text = "Switch is off"


           val duration = Toast.LENGTH_SHORT //= Toast.LENGTH_LONG if Off

           val toast = Toast.makeText(this, text, duration) //this is the ListActivity

           toast.show() //display your message box
        }
        checkBox?.setOnCheckedChangeListener { buttonView, isChecked ->
    if (checkBox.isChecked) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(R.string.dialoug_message).setTitle(R.string.dialoug_title).setPositiveButton(R.string.ok, { dialog, id ->
            val resultIntent = Intent()

            resultIntent.putExtra("Response", "Here is my response")

            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }).setNegativeButton(R.string.cancel, { dialog, id ->
            val resultIntent = Intent()

        }).show()

    }
}

}

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data.extras.get("data") as Bitmap
            imageButton?.setImageBitmap(imageBitmap)
        }
    }



    override fun onResume(){
        super.onResume()
        Log.i(LIST_ACTIVITY,"In onResume")
    }


    override fun onStart(){
        super.onStart()
        Log.i(LIST_ACTIVITY,"In onStart")


    }

    override fun onPause(){
        super.onPause()
        Log.i(LIST_ACTIVITY,"In onPause")
    }

    override fun onStop(){
        super.onStop()
        Log.i(LIST_ACTIVITY,"In onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i(LIST_ACTIVITY,"In onDestroy")
    }





}
