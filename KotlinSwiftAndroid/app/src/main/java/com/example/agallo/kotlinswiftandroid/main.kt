package com.example.agallo.kotlinswiftandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import logic.Words
import android.widget.TextView

class main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val word = Words()
        val textView = findViewById(R.id.textView1) as TextView
        textView.text = word.getWords()
        word.test()
    }
}
