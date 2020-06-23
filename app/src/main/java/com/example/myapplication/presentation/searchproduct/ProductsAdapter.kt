package com.example.myapplication.presentation.searchproduct

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.core.domain.entity.ResultEntity
import com.example.myapplication.R
import com.example.myapplication.presentation.detail.DetailActivity
import com.example.myapplication.presentation.model.ResultPresentation
import com.squareup.picasso.Picasso
import java.util.*

class ProductsAdapter constructor(
    private var itemList: List<ResultPresentation>,
    private var context: Context
) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, null)
        return ViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTopic.text = itemList[position].title
        Picasso.get().load(itemList[position].thumbnail).into(holder.headerImageView)
        val sb = StringBuilder()
        val formatter = Formatter(sb, Locale.US)
        formatter.format("$ %(,.2f", itemList[position].price)
        holder.priceTextView.text = formatter.toString()
    }

    fun updateData(itemList: List<ResultPresentation>) {
        this.itemList = itemList
    }

    override fun getItemCount() = itemList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        var tvTopic: TextView
        var headerImageView: ImageView
        var priceTextView: TextView

        init {
            itemView.setOnClickListener(this)
            tvTopic = itemView.findViewById<View>(R.id.titleTextView) as TextView
            headerImageView = itemView.findViewById(R.id.imageViewHeadeer) as ImageView
            priceTextView = itemView.findViewById(R.id.priceTextView) as TextView
        }

        override fun onClick(view: View) {
            var intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("item", itemList[adapterPosition])
            context.startActivity(intent)

            Toast.makeText(
                view.context,
                "Clicked Position = " + adapterPosition, Toast.LENGTH_SHORT
            )
                .show()
        }
    }
}