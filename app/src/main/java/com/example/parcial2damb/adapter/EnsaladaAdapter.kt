import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial2damb.Ensalada
import com.example.parcial2damb.R

class EnsaladaAdapter(private val ensaladas: List<Ensalada>) :
    RecyclerView.Adapter<EnsaladaAdapter.EnsaladaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnsaladaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ensaladas, parent, false)
        return EnsaladaViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnsaladaViewHolder, position: Int) {
        val ensalada = ensaladas[position]
        holder.textViewNombre.text = ensalada.nombre
        holder.textViewIngredientes.text = ensalada.ingredientes
        holder.imageViewEnsalada.setImageResource(ensalada.imagenResId) // Vincula la imagen
    }

    override fun getItemCount() = ensaladas.size

    class EnsaladaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewNombre: TextView = itemView.findViewById(R.id.textViewNombre)
        val textViewIngredientes: TextView = itemView.findViewById(R.id.textViewIngredientes)
        val imageViewEnsalada: ImageView = itemView.findViewById(R.id.imageViewEnsalada) // Agrega el ImageView
    }
}
