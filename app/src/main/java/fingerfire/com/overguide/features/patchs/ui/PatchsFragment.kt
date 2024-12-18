package fingerfire.com.overguide.features.patchs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fingerfire.com.overguide.R
import fingerfire.com.overguide.databinding.FragmentPatchsBinding
import fingerfire.com.overguide.extensions.isInternetAvailable
import fingerfire.com.overguide.extensions.showDialogOverwatch
import fingerfire.com.overguide.features.patchs.data.response.PatchsDataResponse
import fingerfire.com.overguide.features.patchs.ui.adapter.PatchsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class PatchsFragment : Fragment() {

    private lateinit var binding: FragmentPatchsBinding
    private lateinit var patchsAdapter: PatchsAdapter
    private val viewModel: PatchsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPatchsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!requireActivity().isInternetAvailable()) {
            requireActivity().showDialogOverwatch(R.string.internet)
        } else {
            observerPatchs()

            viewModel.getPatchs()
        }
    }

    private fun observerPatchs() {
        viewModel.patchsLiveData.observe(viewLifecycleOwner) { viewState ->
            if (viewState.sucess != null) {
                initRecyclerView()
                initAdapter(viewState.sucess)
            } else if (viewState.failure) {
                requireActivity().showDialogOverwatch(R.string.failResponse)
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvPatchs.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvPatchs.setHasFixedSize(true)
    }

    private fun initAdapter(patchResponse: List<PatchsDataResponse>) {
        patchsAdapter = PatchsAdapter(patchResponse)
        binding.rvPatchs.adapter = patchsAdapter
    }
}