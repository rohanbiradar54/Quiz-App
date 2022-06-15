package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Questions> ? = null
    private var mSelectedOptionPosition: Int = 0


    private var qs: TextView? = null
    private var img: ImageView? = null
    private var progress: ProgressBar? = null
    private var progressText: TextView? = null
    private var op1: TextView? = null
    private var op2: TextView? = null
    private var op3: TextView? = null
    private var op4: TextView? = null
    private var submitButton: Button? = null

    private var mUserName:String?= null
    private var mCorrectAnswer: Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mUserName=intent.getStringExtra(Data.USER_NAME)

        qs = findViewById(R.id.question)
        img = findViewById(R.id.image)
        progress = findViewById(R.id.progressBar)
        progressText = findViewById(R.id.progress_text)
        op1 = findViewById(R.id.option1)
        op2 = findViewById(R.id.option2)
        op3 = findViewById(R.id.option3)
        op4 = findViewById(R.id.option4)
        submitButton = findViewById(R.id.submit)

        mQuestionList=Data.getQuestions()

        setQuestion()

        op1?.setOnClickListener(this)
        op2?.setOnClickListener(this)
        op3?.setOnClickListener(this)
        op4?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)










    }

    @SuppressLint("SetTextI18n")
    private fun setQuestion() {


        val question: Questions = mQuestionList!![mCurrentPosition - 1]
        defaultOptionsView()
        qs?.text = question.question
        img?.setImageResource(question.image)
        progress?.progress = mCurrentPosition
        progressText?.text = "$mCurrentPosition" + "/" + "${progress?.max}"
        op1?.text = question.option1
        op2?.text = question.option2
        op3?.text = question.option3
        op4?.text = question.option4

        if (mCurrentPosition == mQuestionList!!.size) {
            submitButton?.text = "FINISH"
        } else {
            submitButton?.text = "SUBMIT"
        }


    }

    private fun defaultOptionsView() {
        val option = ArrayList<TextView>()

        op1?.let {
            option.add(0, it)
        }
        op2?.let {
            option.add(1, it)
        }
        op3?.let {
            option.add(2, it)
        }
        op4?.let {
            option.add(3, it)
        }
        for (options in option) {
            options.setTextColor(Color.parseColor("#7A8089"))
            options.typeface = Typeface.DEFAULT
            options.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border
            )
        }


    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_bg
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option1 -> {
                op1?.let { selectedOptionView(it, 1) }
            }
            R.id.option2 -> {
                op2?.let { selectedOptionView(it, 2) }
            }
            R.id.option3 -> {
                op3?.let { selectedOptionView(it, 3) }
            }
            R.id.option4 -> {
                op4?.let { selectedOptionView(it, 4) }
            }
            R.id.submit -> {
                if (mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else->{
//                            Toast.makeText(this, "You have successfully completed the quiz. Your Score is : $mCorrectAnswer", Toast.LENGTH_SHORT).show()
                            val intent=Intent(this, ResultActivity::class.java)
                            intent.putExtra(Data.USER_NAME,mUserName)
                            intent.putExtra(Data.CORRECT_ANS,mCorrectAnswer)
                            intent.putExtra(Data.TOTAL_QS,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val questions=mQuestionList?.get(mCurrentPosition-1)
                    if (questions!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border)
                    }
                    else{
                        mCorrectAnswer++
                        answerView(mSelectedOptionPosition,R.drawable.correct_option_border)
                        if (mCurrentPosition==mQuestionList?.size){
                            submitButton?.text="FINISH QUIZ"

                        }
                        else{
                            submitButton?.text="GO TO NEXT QUESTION"
                        }
                        mSelectedOptionPosition=0
                    }
                }


            }

        }



    }

    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {
            1 -> {
                op1?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2 -> {
                op2?.background = ContextCompat.getDrawable(
                    this, drawableView
                )

            }
            3 -> {
                op3?.background = ContextCompat.getDrawable(
                    this, drawableView
                )

            }
            4 -> {
                op4?.background = ContextCompat.getDrawable(
                    this, drawableView
                )


            }
        }
    }
}