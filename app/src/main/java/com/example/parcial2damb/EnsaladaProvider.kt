package com.example.parcial2damb

object EnsaladaProvider {
    fun obtenerEnsaladas(): List<Ensalada> {
        return listOf(
            Ensalada("Ensalada César", "Lechuga, pollo, crutones, aderezo César", R.drawable.ensalada_cesar),
            Ensalada("Ensalada Griega", "Tomate, pepino, aceitunas, queso feta", R.drawable.ensalada_griega),
            Ensalada("Ensalada de Quinoa", "Quinoa, aguacate, tomate, pepino", R.drawable.ensalada_quinoa),
            Ensalada("Ensalada Caprese", "Tomate, mozzarella, albahaca, aceite de oliva", R.drawable.ensalada_caprese)
        )
    }
}
