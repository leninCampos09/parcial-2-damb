package com.example.parcial2damb.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2damb.Pizza
import com.example.parcial2damb.PizzaProvider.pizzaList
import com.example.parcial2damb.R

class PizzaAdapter(
    private var pizzas: List<Pizza>,
    private val clickListener: (Pizza) -> Unit // Añadido el listener
) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    private var filteredList: List<Pizza> = pizzaList

    class PizzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val pizzaImage: ImageView = itemView.findViewById(R.id.pizza_image)
        val pizzaName: TextView = itemView.findViewById(R.id.pizza_name)
        val pizzaDescription: TextView = itemView.findViewById(R.id.pizza_description)
        val pizzaPrice: TextView = itemView.findViewById(R.id.pizza_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = filteredList[position]
        holder.pizzaImage.setImageResource(pizza.imageResId)
        holder.pizzaName.text = pizza.name
        holder.pizzaDescription.text = pizza.description
        holder.pizzaPrice.text = "$${pizza.price}"

        // Configura el listener para el clic en el elemento
        holder.itemView.setOnClickListener {
            clickListener(pizza) // Llama al listener con el objeto pizza
        }
    }

    fun filter(query: String) {
        filteredList = if (query.isEmpty()) {
            pizzaList // Si no hay consulta, muestra la lista completa
        } else {
            pizzaList.filter { pizza ->
                pizza.name.contains(query, ignoreCase = true) // Filtrar por nombre
            }
        }
        notifyDataSetChanged() // Notificar el cambio para actualizar la vista
    }

    override fun getItemCount(): Int {
        return filteredList.size // Usa filteredList para contar
    }
}
