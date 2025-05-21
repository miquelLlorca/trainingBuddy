package com.example.trainingbuddy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.ListView
import android.widget.ArrayAdapter
import android.content.Intent
import android.widget.Button

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val programs = listOf("Full Body Workout", "Upper Body Blast", "Core Strength")
        val listView = findViewById<ListView>(R.id.programListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, programs)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedProgram = programs[position]
            val intent = Intent(this, TrainingActivity::class.java)
            intent.putExtra("program_name", selectedProgram)
            startActivity(intent)
        }
    
        val createButton = findViewById<Button>(R.id.createProgramButton)
        createButton.setOnClickListener {
            val intent = Intent(this, ProgramCreator::class.java)
            startActivity(intent)
        }
    }
    
    
}