package com.example.parcial2damb

import EnsaladaAdapter
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class EnsaladasActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ensaladaAdapter: EnsaladaAdapter
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ensaladas)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtiene la lista de ensaladas del provider
        val ensaladas = EnsaladaProvider.obtenerEnsaladas()
        ensaladaAdapter = EnsaladaAdapter(ensaladas)
        recyclerView.adapter = ensaladaAdapter

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
                    val intent = Intent(this, FavoritosActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.navigation_salad -> {
                    // Ya estás en EnsaladasActivity
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
}
