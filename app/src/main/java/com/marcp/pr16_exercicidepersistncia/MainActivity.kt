package com.marcp.pr16_exercicidepersistncia

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

            val btn = findViewById<Button>(R.id.button);
            val ett = findViewById<EditText>(R.id.editTextText)
            val etn = findViewById<EditText>(R.id.editTextNumber)

        btn.setOnClickListener {
            val name= ett.text.toString();
            val number = etn.text.toString();
            val filename = "myfile.txt"
            var fileContents: String = "" ;
            if (!name.isNullOrEmpty() && !number.isNullOrEmpty()) {
                fileContents= name+";"+number
            } else if (!name.isNullOrEmpty()) {
                fileContents= name
            } else if (!number.isNullOrEmpty()) {
                fileContents = number
            }
            if (!fileContents.isNullOrEmpty()) {
                fileContents+="\n"
                this.openFileOutput(filename, Context.MODE_APPEND).use {
                    it.write(fileContents.toByteArray())
                }
            }
        }

    }
}