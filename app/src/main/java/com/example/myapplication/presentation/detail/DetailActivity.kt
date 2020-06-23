package com.example.myapplication.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.presentation.model.ResultPresentation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import java.util.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val extras = intent.extras
        val products: ResultPresentation = extras!!.get("item") as ResultPresentation

        setUi(products)

    }

    private fun setUi(product: ResultPresentation) {
        Picasso.get().load(product.thumbnail).into(productImageView)

        if (product.condition.equals("new")) {
            tag.text = "NEW"
        }
        val sb = StringBuilder()
        val formatter = Formatter(sb, Locale.US)
        formatter.format("$ %(,.2f", product.price)
        priceTextView.text = formatter.toString()

        descriptionTextView.text = product.title

        salesNumberValueTextView.text = product.sold_quantity.toString()

        quantityAvailableValueTextView.text = product.available_quantity.toString()

        val isFree: String = if (product.shipping!!.free_shipping.equals("true")) "free" else ""

        tagFreeTextView.text = isFree

        countryTextView.text = product.address!!.state_name

        cityTextView.text = product.address.city_name

    }
}