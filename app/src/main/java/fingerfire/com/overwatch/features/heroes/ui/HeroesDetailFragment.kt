package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.load
import fingerfire.com.overwatch.databinding.FragmentHeroesDetailBinding
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.ui.adapter.AbilitiesAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesDetailFragment : Fragment() {

    private lateinit var binding: FragmentHeroesDetailBinding
    private lateinit var abilitiesAdapter: AbilitiesAdapter
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
//        binding.backButtonImageView.setOnClickListener {
//            findNavController().popBackStack()
//        }
    }

    private fun initUi(heroesDataResponse: HeroesDataResponse) {
        binding.apply {
            heroesDataResponse.let { item ->
                binding.ivHero.load(item.fullPortraitV2)
                binding.tvName.text = item.displayName
                binding.tvDesc.text = item.description
                binding.tvNameReal.text = item.developerName
                binding.tvBase.text = item.location
                binding.tvRole.text = item.role.displayName
                abilitiesAdapter = AbilitiesAdapter(item.abilities, itemClick = {
                    binding.tvAbilitiesName.text = it.displayName
                    binding.tvAbilitiesDesc.text = it.description
                    binding.ivAbilitiesImage.load(it.displayImage)

                })
                binding.rvAbilities.adapter = abilitiesAdapter

                val firstAbility = item.abilities.firstOrNull()
                firstAbility?.let {
                    binding.tvAbilitiesName.text = it.displayName
                    binding.tvAbilitiesDesc.text = it.description
                    binding.ivAbilitiesImage.load(it.displayImage)
                    binding.videoView.setVideoPath(it.displayVideo)
                    binding.videoView.start()
                    abilitiesAdapter.setSelectedItem(0)
                }
            }
        }
    }
}