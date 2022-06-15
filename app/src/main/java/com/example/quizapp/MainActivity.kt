package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button=findViewById(R.id.startButtonID)
        val name: EditText=findViewById(R.id.textID)

        startButton.setOnClickListener {
            if (name.text.isEmpty()){
                Toast.makeText(this,"Enter a valid name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Data.USER_NAME,name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }


}