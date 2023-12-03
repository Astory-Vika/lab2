package com.example.task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(
    private val dataSet: Array<MainItem>, private val onDetailsClick: (MainItem) -> Unit
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView
        val titleTextView: TextView
        val yearTextView: TextView
        val descriptionTextView: TextView

        init {
            imageView = view.findViewById(R.id.itemImageView)
            titleTextView = view.findViewById(R.id.itemTitle)
            yearTextView = view.findViewById(R.id.itemYear)
            descriptionTextView = view.findViewById(R.id.itemDescription)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.titleTextView.text = dataSet[position].title
        viewHolder.yearTextView.text = dataSet[position].year.toString()
        viewHolder.descriptionTextView.text = dataSet[position].description

        Glide
            .with(viewHolder.imageView)
            .load(dataSet[position].image)
            .centerInside()
            .into(viewHolder.imageView)
        viewHolder.itemView.setOnClickListener {
            onDetailsClick(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size
}