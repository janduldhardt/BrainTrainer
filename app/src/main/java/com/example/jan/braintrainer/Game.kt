package com.example.jan.braintrainer

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

const val EXTRA_MESSAGE = "com.example.jan.braintrainer.Score"
const val EXTRA_MESSAGE2 = "com.example.jan.braintrainer.NumberQuestions"



class Game : AppCompatActivity() {

    var answers = ArrayList<Int>()
    public var score : Int = 0;
    public var numberOfQuestions : Int = 0;
    var locationCorrectAnswer : Int = 0;
    var sumAnswer = 0;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        textView2.setText("")
        btnAnswer1.setTag(0)
        btnAnswer2.setTag(1)
        btnAnswer3.setTag(2)
        btnAnswer4.setTag(3)

        textViewScore.setText("$score / $numberOfQuestions")
        gameTimer() //Starts the Countdown when the Timer hits 0 the game is over and starts ResultActivity Screen
        generateQuestion()


    }



    fun chooseAnswer(v : View) {
        if(v.getTag().toString().equals(locationCorrectAnswer.toString())) {
            generateQuestion()
            score++
            numberOfQuestions++
            textViewScore.setText("$score / $numberOfQuestions")
            textView2.setText("Correct")
            textView2.setTextColor(Color.parseColor("#2ac075"))

        } else {
            generateQuestion()
            numberOfQuestions++
            textViewScore.setText("$score / $numberOfQuestions")
            textView2.setText("Wrong")
            textView2.setTextColor(Color.parseColor("#f06261"))
        }


    }

    private fun generateQuestion() {
        answers.clear()
        val rand = Random()

        var a = rand.nextInt(21)
        var b = rand.nextInt(21)

        sumAnswer = a + b
        textView.setText("$a + $b")
        locationCorrectAnswer = rand.nextInt(4)

        for (i in 0..3) {
            if (i == locationCorrectAnswer) {
                answers.add(sumAnswer)
            } else {
                var incorrectAnswer = rand.nextInt(41)
                while (incorrectAnswer == sumAnswer) {
                    incorrectAnswer = rand.nextInt(41)

                }
                answers.add(incorrectAnswer)
            }

        }
        btnAnswer1.setText(Integer.toString(answers.get(0)))
        btnAnswer2.setText(Integer.toString(answers.get(1)))
        btnAnswer3.setText(Integer.toString(answers.get(2)))
        btnAnswer4.setText(Integer.toString(answers.get(3)))
    }


    private fun gameTimer() {
        object : CountDownTimer(30000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                textViewCounterTime.setText(""+millisUntilFinished / 1000 + "s")
            }

            override fun onFinish() {
                startResultActivity()


            }
        }.start()
    }

    fun startResultActivity() {
        val intent = Intent(this@Game, Result::class.java).apply {
            putExtra(EXTRA_MESSAGE, score.toString())
            putExtra(EXTRA_MESSAGE2, numberOfQuestions.toString())
        }
        startActivity(intent)
    }


}
