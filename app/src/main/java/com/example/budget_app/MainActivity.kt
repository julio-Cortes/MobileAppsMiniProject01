package com.example.budget_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.example.navtest.Spend
import com.example.navtest.SpendRecyclerViewAdapter
import com.example.navtest.spendsFactory


class MainActivity : AppCompatActivity(),OnClickListener {

    lateinit var spendsRecyclerView: RecyclerView
    lateinit var adapter: SpendRecyclerViewAdapter
    lateinit var spends:MutableList<Spend>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spendsRecyclerView = findViewById(R.id.spend_recycler_view)
        spendsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = SpendRecyclerViewAdapter()
        adapter.onClickListener = this
        spendsRecyclerView.adapter= adapter

        val addOneSpendButton = findViewById<Button>(R.id.plus_one_button)
        addOneSpendButton.setOnClickListener{
            adapter.addOneCase(spend = spendsFactory(1)[0])
        }
        val addFiveButton = findViewById<Button>(R.id.plus_five_button)

        addFiveButton.setOnClickListener{
            adapter.addFiveCases(spends = spendsFactory(5) as MutableList<Spend>)
        }






    }

    override fun onClickItem(item: Any) {
        if (item is Spend){
            val intent = Intent(this, SpendDetail::class.java)
            intent.putExtra("text",item)
            startActivity(intent)

        }
    }
}