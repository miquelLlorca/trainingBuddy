package com.example.trainingbuddy

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var timerText: TextView
    private lateinit var startButton: Button
    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.timer)

        timerText = findViewById(R.id.timerText)
        startButton = findViewById(R.id.startButton)

        startButton.setOnClickListener {
            startCountdown(30) // Start a 30-second timer
        }
    }

    private fun startCountdown(seconds: Int) {
        timer?.cancel()
        timer = object : CountDownTimer(seconds * 1000L, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secs = millisUntilFinished / 1000
                timerText.text = "Time: $secs s"
            }

            override fun onFinish() {
                timerText.text = "Done!"
            }
        }.start()
    }
}