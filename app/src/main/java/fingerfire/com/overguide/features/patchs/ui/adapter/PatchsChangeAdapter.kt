package fingerfire.com.overguide.features.patchs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import fingerfire.com.overguide.databinding.ItemChangesBinding
import fingerfire.com.overguide.features.patchs.data.response.PatchsChangeDataResponse

class PatchsChangeAdapter(
    private var patchsChangeList: List<PatchsChangeDataResponse>?
) : RecyclerView.Adapter<PatchsChangeAdapter.PatchsChangeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatchsChangeViewHolder {
        val binding = ItemChangesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PatchsChangeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PatchsChangeViewHolder, position: Int) {
        val patch = patchsChangeList?.get(position)
        patch?.let { patch ->
            with(holder.binding) {
                imAbilities.load(patch.displayIcon)
                tvAbilitiesName.text = patch.displayName
                tvChangesDesc.text = patch.changeOne
                tvChangesDesc2.text = patch.changeTwo
            }
        }
    }

    override fun getItemCount(): Int {
        return patchsChangeList?.size ?: 0
    }

    class PatchsChangeViewHolder(val binding: ItemChangesBinding) :
        RecyclerView.ViewHolder(binding.root)
}