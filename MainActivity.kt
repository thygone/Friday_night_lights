package com.example.quizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.solver.widgets.WidgetContainer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_start: Button = findViewById(R.id.btn_start)
        btn_start.setOnClickListener {
            val intent = Intent(this, QuizQuestions::class.java)
            startActivity(intent)
            finish()
        }

    }
}