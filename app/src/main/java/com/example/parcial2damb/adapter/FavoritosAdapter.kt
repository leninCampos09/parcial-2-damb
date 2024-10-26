package com.example.parcial2damb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2damb.Pizza
import com.example.parcial2damb.R

class FavoritosAdapter(private val favorites: List<Pizza>, private val onClick: (Pizza) -> Unit) :
    RecyclerView.Adapter<FavoritosAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.pizza_name)
        private val imageView: ImageView = itemView.findViewById(R.id.pizza_image)

        fun bind(pizza: Pizza) {
            nameTextView.text = pizza.name
            imageView.setImageResource(pizza.imageResId)
            itemView.setOnClickListener { onClick(pizza) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pizza, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(favorites[position])
    }

    override fun getItemCount() = favorites.size
}
