package com.example.myapplication.presentation.searchproduct

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.domain.entity.ResultEntity
import com.example.myapplication.R
import com.example.myapplication.presentation.model.ResultPresentation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    lateinit var mainViewModel: MainViewModel
    lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        setObserver()
        configUI()
    }

    private fun setObserver() {
        mainViewModel.getOnInitialValueDetectedLiveData().observe(this, Observer {
            refreshData(it)
        })
    }

    private fun refreshData(listToShow: List<ResultPresentation>) {
        productsAdapter.updateData(listToShow)
        productsAdapter.notifyDataSetChanged()

    }

    private fun configUI() {
        val gridLayoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = gridLayoutManager
        productsAdapter =
            ProductsAdapter(
                arrayListOf<ResultPresentation>(),
                this
            )
        recyclerView.adapter = productsAdapter

        val verticalDecorator = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val horizontalDecorator = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        var drawable = ContextCompat.getDrawable(this, R.drawable.divider_item);
        verticalDecorator.setDrawable(drawable!!)
        horizontalDecorator.setDrawable(drawable!!)
        recyclerView.addItemDecoration(verticalDecorator);
        recyclerView.addItemDecoration(horizontalDecorator);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        var itemMenu: MenuItem = menu!!.findItem(R.id.action_search)
        var searchView: SearchView = itemMenu.actionView as SearchView
        searchView.queryHint = getString(R.string.search_msg)
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        mainViewModel.searchProduct(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        // No its necessary implement this method
        return true
    }


}
