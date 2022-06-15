package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView=findViewById(R.id.user)
        val tvScore:TextView= findViewById(R.id.tv_score)
        val finishButton:Button= findViewById(R.id.finish)

        val username =intent.getStringExtra(Data.USER_NAME)
        val totalQs=intent.getIntExtra(Data.TOTAL_QS,0)
        val correctAns=intent.getIntExtra(Data.CORRECT_ANS,0)

        tvName.text="$username"
        tvScore.text="Your score is $correctAns out of $totalQs"

        finishButton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }


    }


}