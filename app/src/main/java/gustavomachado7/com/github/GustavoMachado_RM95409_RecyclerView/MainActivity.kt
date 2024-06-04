package gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView.adapter.ItemsAdapter
import gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView.model.ItemModel
import gustavomachado7.com.github.GustavoMachado_RM95409_RecyclerView.ui.theme.GustavoMachado_RM95409_RecyclerViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editTextNomePraia = findViewById<EditText>(R.id.editTextNomePraia)
        val editTextEstado = findViewById<EditText>(R.id.editTextEstado)
        val editTextCidade = findViewById<EditText>(R.id.editTextCidade)

        button.setOnClickListener {
            if (editTextNomePraia.text.isEmpty()) {
                editTextNomePraia.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (editTextNomePraia.text.toString().length < 4) {
                editTextNomePraia.error = "Quantidade mínima de caracteres não atingida"
                return@setOnClickListener
            }

            if (editTextEstado.text.isEmpty()) {
                editTextEstado.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (editTextEstado.text.toString().length < 4) {
                editTextEstado.error = "Quantidade mínima de caracteres não atingida"
                return@setOnClickListener
            }

            if (editTextCidade.text.isEmpty()) {
                editTextCidade.error = "Preencha um valor"
                return@setOnClickListener
            }

            if (editTextCidade.text.toString().length < 4) {
                editTextCidade.error = "Quantidade mínima de caracteres não atingida"
                return@setOnClickListener
            }

            val item = ItemModel(
                nomePraia = editTextNomePraia.text.toString(),
                estado = editTextEstado.text.toString(),
                cidade = editTextCidade.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(item)
            editTextNomePraia.text.clear()
            editTextEstado.text.clear()
            editTextCidade.text.clear()
        }

    }
}