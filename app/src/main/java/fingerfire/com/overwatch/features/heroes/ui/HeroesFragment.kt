package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fingerfire.com.overwatch.R
import fingerfire.com.overwatch.databinding.FragmentHeroesBinding
import fingerfire.com.overwatch.extensions.initAdMob
import fingerfire.com.overwatch.extensions.isInternetAvailable
import fingerfire.com.overwatch.extensions.showDialogOverwatch
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.ui.adapter.HeroesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesFragment : Fragment() {

    private lateinit var binding: FragmentHeroesBinding
    private lateinit var heroesAdapter: HeroesAdapter
    private val viewModel: HeroesViewModel by viewModel()

    private var currentPosition = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!requireActivity().isInternetAvailable()) {
            requireActivity().showDialogOverwatch(R.string.internet)
        } else {
            observerHeroes()

            viewModel.getHeroes()
        }
    }

    private fun observerHeroes() {
        viewModel.heroesLiveData.observe(viewLifecycleOwner) { viewState ->
            if (viewState.sucess != null) {
                initRecyclerView()
                initAdapter(viewState.sucess)
                binding.adView.initAdMob()
            } else if (viewState.failure) {
                requireActivity().showDialogOverwatch(R.string.failResponse)

            }
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager =
            GridLayoutManager(activity, 2)
        binding.recyclerView.scrollToPosition(currentPosition)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.onFlingListener = null

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                currentPosition = (binding.recyclerView.layoutManager as GridLayoutManager)
                    .findFirstVisibleItemPosition()
            }
        })
    }

    private fun initAdapter(heroesResponse: List<HeroesDataResponse>) {
        heroesAdapter = HeroesAdapter(heroesResponse, itemClick = {
            it._id.let { _id ->
                findNavController().navigate(
                    HeroesFragmentDirections.actionHeroesFragmentToHeroesDetailFragment(
                        _id
                    )
                )
            }
        })
        binding.recyclerView.adapter = heroesAdapter
    }
}