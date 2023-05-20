package fingerfire.com.overwatch.features.patchs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overwatch.databinding.ItemPatchsBinding
import fingerfire.com.overwatch.databinding.ItemPatchsChangesBinding
import fingerfire.com.overwatch.features.patchs.data.response.PatchsChangeDataResponse
import fingerfire.com.overwatch.features.patchs.data.response.PatchsDataResponse

class PatchsChangeAdapter(
    private var patchsChangeList: List<PatchsChangeDataResponse>
) : RecyclerView.Adapter<PatchsChangeAdapter.PatchsChangeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatchsChangeViewHolder {
        return PatchsChangeViewHolder(
            ItemPatchsChangesBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PatchsChangeViewHolder, position: Int) {
        with(holder) {
            with(patchsChangeList[position]) {
                binding.imAbilities.load(displayIcon)
                binding.tvAbilitiesName.text = displayName
                binding.tvChangesDesc.text = changeOne
                binding.tvChangesDesc2.text = changeTwo
            }
        }
    }

    override fun getItemCount(): Int {
        return patchsChangeList.size
    }

    class PatchsChangeViewHolder(val binding: ItemPatchsChangesBinding) : RecyclerView.ViewHolder(binding.root)

}