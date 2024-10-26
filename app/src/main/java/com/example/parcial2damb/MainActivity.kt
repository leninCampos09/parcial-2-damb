package com.example.parcial2damb
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2damb.adapter.PizzaAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var pizzaAdapter: PizzaAdapter
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private lateinit var toolbar: Toolbar
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Configuración de la Toolbar
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recycler_view)
        searchView = findViewById(R.id.search_view)

        // Cambia el LayoutManager a GridLayoutManager
        val gridLayoutManager = GridLayoutManager(this, 2) // 2 columnas
        recyclerView.layoutManager = gridLayoutManager

        // Configura el adapter de pizzas
        pizzaAdapter = PizzaAdapter(PizzaProvider.pizzaList) { pizza ->
            val intent = Intent(this, PizzaDetailActivity::class.java).apply {
                putExtra("image", pizza.imageResId)
                putExtra("name", pizza.name)
                putExtra("description", pizza.description)
                putExtra("price", pizza.price)
            }
            startActivity(intent)
        }
        recyclerView.adapter = pizzaAdapter

        // Configura el SearchView
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                pizzaAdapter.filter(newText ?: "")
                return true
            }
        })

        // Configura el BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation) // Asegúrate de que el ID coincida
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_menu -> {
                    // Manejar acción del menú
                    true
                }
                R.id.navigation_favorites -> {
                    // Crear un Intent para la actividad de favoritos
                    val intent = Intent(this, FavoritosActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_salad -> {
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

    // Inflar el menú de la toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu) // Cambia "toolbar_menu" por el nombre de tu archivo de menú
        return true
    }

    // Manejar los clics de los elementos del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_gift -> {
                // Manejar acción de regalo
                true
            }
            R.id.action_exit -> {
                // Manejar acción de salir

                true
            }
            R.id.action_back -> {
                // Manejar acción de volver

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
