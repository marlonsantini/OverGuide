package fingerfire.com.overwatch.features.heroes.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overwatch.databinding.ItemHeroesBinding
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse

class HeroesAdapter(
    private var heroesList: List<HeroesDataResponse>,
    private val itemClick: (HeroesDataResponse) -> Unit
) : RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    //private var _heroesList = heroesList.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        return HeroesViewHolder(
            ItemHeroesBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        with(holder) {
            with(heroesList[position]) {
                binding.imHeroes.load(bustPortrait)

                binding.imHeroes.setOnClickListener {
                    itemClick.invoke(heroesList[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }


    class HeroesViewHolder(val binding: ItemHeroesBinding) : RecyclerView.ViewHolder(binding.root)


}