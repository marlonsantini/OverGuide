package fingerfire.com.overwatch.features.patchs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fingerfire.com.overwatch.databinding.ItemPatchsBinding
import fingerfire.com.overwatch.features.patchs.data.response.PatchsDataResponse

class PatchsAdapter(
    private var patchsList: List<PatchsDataResponse>
) : RecyclerView.Adapter<PatchsAdapter.PatchsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatchsViewHolder {
        return PatchsViewHolder(
            ItemPatchsBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PatchsViewHolder, position: Int) {
        with(holder) {
            with(patchsList[position]) {

            }
        }
    }

    override fun getItemCount(): Int {
        return patchsList.size
    }

    class PatchsViewHolder(val binding: ItemPatchsBinding) : RecyclerView.ViewHolder(binding.root)

}