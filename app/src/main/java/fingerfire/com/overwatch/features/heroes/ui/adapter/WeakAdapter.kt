package fingerfire.com.overwatch.features.heroes.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overwatch.databinding.ItemComboBinding
import fingerfire.com.overwatch.features.heroes.data.response.WeakResponse

class WeakAdapter(
    private val weakList: List<WeakResponse>
) : RecyclerView.Adapter<WeakAdapter.WeakViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeakViewHolder {
        return WeakViewHolder(
            ItemComboBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeakViewHolder, position: Int) {
        with(holder) {
            with(weakList[position]) {
                loadHeroImage(heroWeak, binding.ivCombo, binding.loadingProgressBar)
            }
        }
    }

    override fun getItemCount(): Int {
        return weakList.size
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

    class WeakViewHolder(val binding: ItemComboBinding) : RecyclerView.ViewHolder(binding.root)

}