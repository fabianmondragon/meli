package com.example.myapplication.presentation

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.domain.entity.ResultEntity
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var mainViewModel: MainViewModel
    lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        textView = findViewById(R.id.TextView)
        textView.setOnClickListener { v: View ->
            Toast.makeText(this, "hola", Toast.LENGTH_LONG).show()
            mainViewModel.searchProduct()

        }
        setObserver()
        configUI()
    }

    private fun setObserver() {
        mainViewModel.getOnInitialValueDetectedLiveData().observe(this, Observer {
            refreshData(it)
        })
    }

    private fun refreshData(listToShow: List<ResultEntity>) {
        productsAdapter.updateData(listToShow)
        productsAdapter.notifyDataSetChanged()

    }

    private fun configUI() {
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager
        productsAdapter = ProductsAdapter(arrayListOf<ResultEntity>())
        recyclerView.adapter = productsAdapter

        val verticalDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val horizontalDecorator = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        var drawable = ContextCompat.getDrawable(this, R.drawable.divider_item);
        verticalDecorator.setDrawable(drawable!!)
        horizontalDecorator.setDrawable(drawable!!)
        recyclerView.addItemDecoration(verticalDecorator);
        recyclerView.addItemDecoration(horizontalDecorator);

    }
}
