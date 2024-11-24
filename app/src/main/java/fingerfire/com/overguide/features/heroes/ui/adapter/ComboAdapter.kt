package fingerfire.com.overguide.features.heroes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overguide.databinding.ItemComboBinding
import fingerfire.com.overguide.features.heroes.data.response.ComboResponse

class ComboAdapter(
    private val comboList: List<ComboResponse>
) : RecyclerView.Adapter<ComboAdapter.ComboViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComboViewHolder {
        return ComboViewHolder(
            ItemComboBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ComboViewHolder, position: Int) {
        with(holder) {
            with(comboList[position]) {
                loadHeroImage(heroCombo, binding.ivCombo, binding.loadingProgressBar)
            }
        }
    }

    override fun getItemCount(): Int {
        return comboList.size
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

    class ComboViewHolder(val binding: ItemComboBinding) : RecyclerView.ViewHolder(binding.root)

}