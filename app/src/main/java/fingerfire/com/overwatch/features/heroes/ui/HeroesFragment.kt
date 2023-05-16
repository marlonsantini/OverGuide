package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import fingerfire.com.overwatch.databinding.FragmentHeroesBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesFragment : Fragment() {

    private lateinit var binding: FragmentHeroesBinding
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
        viewModel.heroesLiveData.observe(viewLifecycleOwner) {
            val teste = it.sucess
            binding.imageView.load(teste?.data?.get(0)?.fullPortrait ?: "fail")
            binding.imageView2.load(teste?.data?.get(0)?.bustPortrait ?: "fail")

        }
    }
}