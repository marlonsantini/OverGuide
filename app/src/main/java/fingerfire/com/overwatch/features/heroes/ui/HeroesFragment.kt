package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import fingerfire.com.overwatch.databinding.FragmentHeroesBinding
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.data.response.HeroesResponse
import fingerfire.com.overwatch.features.heroes.ui.adapter.HeroesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesFragment : Fragment() {

    private lateinit var binding: FragmentHeroesBinding
    private lateinit var heroesAdapter: HeroesAdapter
    private val viewModel: HeroesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerHeroes()

        viewModel.getHeroes()

    }

    private fun observerHeroes() {
        viewModel.heroesLiveData.observe(viewLifecycleOwner) { viewState ->
            if (viewState.sucess != null) {
                initRecyclerView()
                initAdapter(viewState.sucess)
            } else if (viewState.failure) {

            }
        }
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager =
            GridLayoutManager(activity, 2)
        binding.recyclerView.setHasFixedSize(true)
    }

    private fun initAdapter(heroesResponse: HeroesResponse) {
        heroesAdapter = HeroesAdapter(heroesResponse.data)
        binding.recyclerView.adapter = heroesAdapter
    }
}