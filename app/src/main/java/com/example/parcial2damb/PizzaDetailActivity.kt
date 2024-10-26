package com.example.parcial2damb

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PizzaDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pizza_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageView: ImageView = findViewById(R.id.image_view)
        val nameTextView: TextView = findViewById(R.id.name_text_view)
        val descriptionTextView: TextView = findViewById(R.id.description_text_view)
        val priceTextView: TextView = findViewById(R.id.price_text_view)

        // Recibe los datos del Intent
        val image = intent.getIntExtra("image", 0)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val price = intent.getStringExtra("price")

        // Configura las vistas
        imageView.setImageResource(image)
        nameTextView.text = name
        descriptionTextView.text = description
        priceTextView.text = price
    }
}