package fingerfire.com.overwatch.features.maps.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fingerfire.com.overwatch.databinding.FragmentMapsBinding
import fingerfire.com.overwatch.features.maps.ui.adapter.MapsAdapter
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
        observerMaps()

    }

    private fun observerMaps() {
        viewModel.mapsLiveData.observe(viewLifecycleOwner) { viewState ->
            if (viewState.sucess != null) {
//                initRecyclerView()
//                initAdapter(viewState.sucess)
            } else if (viewState.failure) {

            }
        }
    }



}