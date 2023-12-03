package com.example.task1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

private const val IMAGE = "IMAGE"
private const val TITLE = "TITLE"
private const val DESCRIPTION = "DESCRIPTION"
private const val YEAR = "YEAR"


class DetailsFragment : Fragment(R.layout.fragment_details) {
    private var image: String? = null
    private var title: String? = null
    private var description: String? = null
    private var year: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getString(IMAGE)
            title = it.getString(TITLE)
            description = it.getString(DESCRIPTION)
            year = it.getInt(YEAR)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageView = view.findViewById<ImageView>(R.id.detailsImageView)
        val titleTextView = view.findViewById<TextView>(R.id.detailsTitle)
        val yearTextView = view.findViewById<TextView>(R.id.detailsYear)
        val descriptionTextView = view.findViewById<TextView>(R.id.detailsDescription)

        titleTextView.text = title ?: "Unknown title"
        yearTextView.text = year?.toString() ?: "Unknown year"
        descriptionTextView.text = description ?: "Unknown description"

        image?.let {
            Glide
                .with(imageView)
                .load(it)
                .centerCrop()
                .into(imageView)
        }
    }

    companion object {
        @JvmStatic
        fun prepareBundle(image: String, title: String, description: String, year: Int) =
            Bundle().apply {
                putString(IMAGE, image)
                putString(TITLE, title)
                putString(DESCRIPTION, description)
                putInt(YEAR, year)

            }
    }
}