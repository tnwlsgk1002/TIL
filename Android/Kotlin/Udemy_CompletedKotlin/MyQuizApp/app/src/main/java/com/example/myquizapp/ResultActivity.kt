package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var tvName : TextView = findViewById(R.id.tv_name)
        var tvScore : TextView = findViewById(R.id.tv_score)
        var btnFinish : Button = findViewById(R.id.btn_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvScore.text = "Your Score is $correctAnswer out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}