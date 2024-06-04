package gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView.R
import gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView.model.ItemModel


class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNomePraia = view.findViewById<TextView>(R.id.textViewNomePraia)
        val textViewEstado = view.findViewById<TextView>(R.id.textViewEstado)
        val textViewCidade = view.findViewById<TextView>(R.id.textViewCidade)
        val button = view.findViewById<ImageButton>(R.id.imageButton)


        fun bind(item: ItemModel) {
            textViewNomePraia.text = item.nomePraia
            textViewEstado.text = item.estado
            textViewCidade.text = item.cidade

            button.setOnClickListener {
                item.onRemove(item)
            }
        }
    }
}