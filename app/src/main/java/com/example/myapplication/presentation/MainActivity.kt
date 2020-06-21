package com.example.myapplication.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.core.domain.entity.ResultEntity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {


    lateinit var textView: TextView


    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        textView = findViewById(R.id.TextView)
        textView.setOnClickListener { v: View ->
            Toast.makeText(this, "hola", Toast.LENGTH_LONG).show()
            mainViewModel.searchProduct()

        }
        setObserver();
    }

    private fun setObserver() {
        mainViewModel.getOnInitialValueDetectedLiveData().observe(this, Observer {
            refreshData(it)
        })
    }

    private fun refreshData(listToShow: List<ResultEntity>) {
        val hola = "";

    }
}
