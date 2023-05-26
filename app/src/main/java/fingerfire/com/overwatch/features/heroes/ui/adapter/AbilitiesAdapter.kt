package fingerfire.com.overwatch.features.heroes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overwatch.R
import fingerfire.com.overwatch.databinding.ItemAbilitiesBinding
import fingerfire.com.overwatch.features.heroes.data.response.AbilitiesResponse

class AbilitiesAdapter(
    private val abilitiesList: List<AbilitiesResponse>,
    private val itemClick: (AbilitiesResponse) -> Unit,
    private var selectedItemIndex: Int = RecyclerView.NO_POSITION
) : RecyclerView.Adapter<AbilitiesAdapter.AbilitiesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesViewHolder {
        val binding = ItemAbilitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AbilitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AbilitiesViewHolder, position: Int) {
        val item = abilitiesList[position]
        holder.bind(item, position == selectedItemIndex)
    }


    override fun getItemCount(): Int {
        return abilitiesList.size
    }

    inner class AbilitiesViewHolder(private val binding: ItemAbilitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: AbilitiesResponse, isSelected: Boolean) {
            with(binding) {
                imAbilities.load(item.displayIcon)

                if (isSelected) {
                    // Aplicar estilo para o item selecionado
                    // Exemplo: Alterar a cor de fundo, adicionar borda, etc.
                    binding.imAbilities.setBackgroundResource(R.drawable.circle_background_orange)
                } else {
                    // Restaurar o estilo para os itens não selecionados
                    binding.imAbilities.setBackgroundResource(R.drawable.circle_background)
                }

                cvAbilities.setOnClickListener {
                    itemClick.invoke(item)

                    // Atualizar o índice do item selecionado
                    val previousSelectedItemIndex = selectedItemIndex
                    selectedItemIndex = adapterPosition

                    // Notificar a atualização nos itens afetados
                    notifyItemChanged(previousSelectedItemIndex)
                    notifyItemChanged(selectedItemIndex)
                }
            }
        }
    }

    fun setSelectedItem(index: Int) {
        val previousSelectedItemIndex = selectedItemIndex
        selectedItemIndex = index
        notifyItemChanged(previousSelectedItemIndex)
        notifyItemChanged(selectedItemIndex)
    }
}