package com.example.amazonui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazonui.R
import com.example.amazonui.model.Essential

class FavoriteAdapter(private val context: Context, private val list: ArrayList<Essential>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater =
            LayoutInflater.from(context).inflate(R.layout.item_feed_essential, parent, false)

        return EssentialViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val essential = list[position]

        if (holder is EssentialViewHolder) {
            val imageView = (holder as EssentialViewHolder).imageView
            val titleTextView = (holder as EssentialViewHolder).titleTextView

            imageView.setImageResource(essential.image)
            titleTextView.text = essential.title
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    private class EssentialViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tv_title)
        val imageView: ImageView = itemView.findViewById(R.id.iv_image)
    }
}