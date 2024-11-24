package fingerfire.com.overguide.features.maps.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fingerfire.com.overguide.R
import fingerfire.com.overguide.databinding.FragmentMapsBinding
import fingerfire.com.overguide.extensions.isInternetAvailable
import fingerfire.com.overguide.extensions.showDialogOverwatch
import fingerfire.com.overguide.features.maps.data.response.MapsDataResponse
import fingerfire.com.overguide.features.maps.ui.adapter.MapsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding
    private lateinit var mapsAdapter: MapsAdapter
    private val viewModel: MapsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!requireActivity().isInternetAvailable()) {
            requireActivity().showDialogOverwatch(R.string.internet)
        } else {
            observerMaps()

            viewModel.getMaps()
        }
    }

    private fun observerMaps() {
        viewModel.mapsLiveData.observe(viewLifecycleOwner) { viewState ->
            if (viewState.sucess != null) {
                initRecyclerView()
                initAdapter(viewState.sucess)
            } else if (viewState.failure) {
                requireActivity().showDialogOverwatch(R.string.failResponse)
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvMaps.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.rvMaps.setHasFixedSize(true)
    }

    private fun initAdapter(mapsResponse: List<MapsDataResponse>) {
        mapsAdapter = MapsAdapter(mapsResponse)
        binding.rvMaps.adapter = mapsAdapter
    }
}