package fingerfire.com.overwatch.features.heroes.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overwatch.databinding.ItemExpansionHistoryBinding
import fingerfire.com.overwatch.features.heroes.data.response.HistoryResponse

class HistoryAdapter(
    private val abilitiesList: List<HistoryResponse>,
    private val context: Context,
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding =
            ItemExpansionHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        with(holder) {
            with(abilitiesList[position]) {
                binding.titleChapter.text = session
                binding.descHero.text = description
                binding.ivDescHero.load(displayIcon)

                if (isExpanded) {
                    binding.ivDescHero.visibility = View.VISIBLE
                    binding.descHero.visibility = View.VISIBLE
                } else {
                    binding.ivDescHero.visibility = View.GONE
                    binding.descHero.visibility = View.GONE
                }
                // Definir o clique no item para alternar a expansão
                itemView.setOnClickListener {
                    isExpanded = !isExpanded
                    notifyItemChanged(position)
                }

                binding.ivDescHero.setOnClickListener {
                    Toast.makeText(context, "teste", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return abilitiesList.size
    }

    class HistoryViewHolder(val binding: ItemExpansionHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}
