package gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView.model

data class ItemModel(
    val nomePraia: String,
    val estado: String,
    val cidade: String,
    val onRemove: (ItemModel) -> Unit

)
