package fingerfire.com.overwatch.features.maps.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fingerfire.com.overwatch.databinding.ItemHeroesBinding
import fingerfire.com.overwatch.databinding.ItemMapsBinding
import fingerfire.com.overwatch.features.heroes.ui.adapter.HeroesAdapter
import fingerfire.com.overwatch.features.maps.data.response.MapsDataResponse

class MapsAdapter(
    private var mapsList: List<MapsDataResponse>
) : RecyclerView.Adapter<MapsAdapter.MapsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsViewHolder {
        return MapsViewHolder(
            ItemMapsBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MapsViewHolder, position: Int) {
        with(holder) {
            with(mapsList[position]) {

            }
        }
    }

    override fun getItemCount(): Int {
        return mapsList.size
    }

    class MapsViewHolder(val binding: ItemMapsBinding) : RecyclerView.ViewHolder(binding.root)

}