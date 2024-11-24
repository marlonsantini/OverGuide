package fingerfire.com.overguide.features.heroes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overguide.databinding.ItemHeroesBinding
import fingerfire.com.overguide.features.heroes.data.response.HeroesDataResponse

class HeroesAdapter(
    private var heroesList: List<HeroesDataResponse>,
    private val itemClick: (HeroesDataResponse) -> Unit
) : RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        return HeroesViewHolder(
            ItemHeroesBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        with(holder) {
            with(heroesList[position]) {
                loadHeroImage(bustPortrait, binding.imHeroes, binding.loadingProgressBar)

                binding.imHeroes.setOnClickListener {
                    itemClick.invoke(heroesList[position])
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return heroesList.size
    }

    private fun loadHeroImage(imageUri: String, imageView: ImageView, progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE

        imageView.load(imageUri) {
            crossfade(true)
            listener(
                onSuccess = { _, _ ->
                    progressBar.visibility = View.GONE
                },
                onError = { _, _ ->
                    progressBar.visibility = View.GONE
                }
            )
        }
    }


    class HeroesViewHolder(val binding: ItemHeroesBinding) : RecyclerView.ViewHolder(binding.root)

}