package com.example.jan.braintrainer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        TextViewResult.setText(textViewScore.toString())

        btnPlayAgain.setOnClickListener{
            val intent = Intent(this, Game::class.java)
            startActivity(intent)
        }
    }
}
