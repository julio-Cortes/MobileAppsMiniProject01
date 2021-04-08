package com.example.budget_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.navtest.Spend

class SpendDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spend_detail)
        val text = intent.getParcelableExtra<Spend>("text")
        findViewById<TextView>(R.id.textView).text = text?.categoryTitle+"\n"+text?.getAmountFormat()
    }
}