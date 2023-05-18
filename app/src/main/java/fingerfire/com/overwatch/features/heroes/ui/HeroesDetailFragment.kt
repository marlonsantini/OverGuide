package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fingerfire.com.overwatch.databinding.FragmentHeroesDetailBinding
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesDetailFragment : Fragment() {

    private lateinit var binding: FragmentHeroesDetailBinding
    private val args: HeroesDetailFragmentArgs by navArgs()
    private val viewModel: HeroesDetailViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getHeroesDetail(args.id)
        initHeroesDetailObserve()
        initBackButtonClickListener()
    }

    private fun initHeroesDetailObserve() {
        viewModel.heroesDetailLiveData.observe(viewLifecycleOwner) {
            initUi(it)
        }
    }

    private fun initBackButtonClickListener() {
        binding.backButtonImageView.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initUi(heroesDataResponse: HeroesDataResponse) {
        binding.apply {
            heroesDataResponse.let { item ->
                binding.tvHeroesName.text = item.displayName
            }
        }
    }
}