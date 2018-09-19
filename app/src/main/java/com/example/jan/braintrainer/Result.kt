package com.example.jan.braintrainer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result2.*

class Result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        val score = intent.getStringExtra(EXTRA_MESSAGE)
        textViewScore.setText(score)

        val numberOfQuestions = intent.getStringExtra(EXTRA_MESSAGE2)
        textViewQuestionsNumber.setText(numberOfQuestions)

        val correct = score.toInt()
        val questionNum = 100f
        val percent = correct * 100.0f / numberOfQuestions.toInt()
        textViewPercent.setText(percent.toString() + "%")


        buttonPlayAgain.setOnClickListener {
            val intent = Intent(this@Result, Game::class.java)
            startActivity(intent)
        }

    }
}
