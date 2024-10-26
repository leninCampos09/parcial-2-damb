package com.example.parcial2damb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2damb.adapter.FavoritosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritosActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var favoritosAdapter: FavoritosAdapter
    private val favorites = mutableListOf<Pizza>() // Aquí puedes cargar tus elementos favoritos
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        recyclerView = findViewById(R.id.recycler_view_favoritos)

        // Cambia LinearLayoutManager por GridLayoutManager para tener 2 columnas
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columnas

        // Cargar los elementos favoritos
        loadFavorites()

        favoritosAdapter = FavoritosAdapter(favorites) { pizza ->
            // Manejar clic en el elemento de la lista
            val intent = Intent(this, PizzaDetailActivity::class.java).apply {
                putExtra("image", pizza.imageResId)
                putExtra("name", pizza.name)
                putExtra("description", pizza.description)
                putExtra("price", pizza.price)
            }
            startActivity(intent)
        }

        recyclerView.adapter = favoritosAdapter

        // Configura el BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation) // Asegúrate de que el ID coincida
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_menu -> {
                    // Manejar acción del menú
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_favorites -> {
                    // No necesitas hacer nada ya que ya estás en FavoritosActivity
                    true
                }
                R.id.navigation_salad -> {
                    // Manejar acción de cupones
                    val intent = Intent(this, EnsaladasActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_profile -> {
                    // Manejar acción de perfil
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFavorites() {
        favorites.add(
            Pizza(
                R.drawable.pizzamargarita,
                "Margherita",
                "Tomate, mozzarella y albahaca",
                8.99
            )
        )
        favorites.add(
            Pizza(
                R.drawable.peperoni,
                "Pepperoni",
                "Salami picante, queso y tomate",
                9.99
            )
        )
        favorites.add(Pizza(R.drawable.hawainna, "Hawaiana", "Jamón, piña y queso", 10.49))
        favorites.add(
            Pizza(
                R.drawable.veggie,
                "Vegetariana",
                "Pimientos, cebollas, champiñones y aceitunas",
                9.49
            )
        )
        favorites.add(Pizza(R.drawable.chicken, "Pollo BBQ", "Salsa BBQ, pollo y queso", 11.99))
        favorites.add(
            Pizza(
                R.drawable.meat_lovers,
                "Amantes de la carne",
                "Pepperoni, salchicha, tocino y jamón",
                12.99
            )
        )
    }
}
