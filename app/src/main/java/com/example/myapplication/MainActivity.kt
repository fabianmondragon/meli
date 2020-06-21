package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.core.data.repository.SearchProductRemoteDataSource
import com.example.core.data.repository.SearchRepository
import com.example.core.domain.usecases.SearchProduct
import com.example.myapplication.data.network.SearchProductRemoteDataSourceImpl
import com.example.myapplication.data.network.SearchRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var searchProduct: SearchProduct
    lateinit var searchRepository: SearchRepository
    lateinit var searchRemoteDataSource : SearchProductRemoteDataSourceImpl
    lateinit var textView: TextView
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        searchRemoteDataSource = SearchProductRemoteDataSourceImpl()
        searchRepository = SearchRepositoryImpl(searchRemoteDataSource)
        searchProduct = SearchProduct(searchRepository)


        textView = findViewById(R.id.TextView)
        textView.setOnClickListener { v: View ->
            Toast.makeText(this, "hola", Toast.LENGTH_LONG).show()
            coroutineScope.launch {
                searchProduct.searchRepository()
            }
        }

    }
}
