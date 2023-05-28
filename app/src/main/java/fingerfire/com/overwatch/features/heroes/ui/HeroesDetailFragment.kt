package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import fingerfire.com.overwatch.databinding.FragmentHeroesDetailBinding
import fingerfire.com.overwatch.features.heroes.data.response.AbilitiesResponse
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
                loadDetail(item)
                abilitiesAdapter = AbilitiesAdapter(item.abilities, itemClick = {
                    binding.tvAbilitiesName.text = it.displayName
                    binding.tvAbilitiesDesc.text = it.description
                    loadAbilityImage(it.displayImage)
                })
                binding.rvAbilities.adapter = abilitiesAdapter
                selectFirstAbility(item.abilities)
            }
        }
    }

    private fun loadDetail(heroesDataResponse: HeroesDataResponse) {
        with(binding) {
            ivHero.load(heroesDataResponse.fullPortraitV2)
            tvName.text = heroesDataResponse.displayName
            tvDesc.text = heroesDataResponse.description
            tvNameReal.text = heroesDataResponse.developerName
            tvBase.text = heroesDataResponse.location
            tvRole.text = heroesDataResponse.role.displayName
        }
    }

    private fun loadAbilityImage(imageUri: String) {
        binding.loadingProgressBar.visibility = View.VISIBLE

        binding.ivAbilitiesImage.load(imageUri) {
            crossfade(true)
            listener(
                onSuccess = { _, _ ->
                    binding.loadingProgressBar.visibility = View.GONE
                },
                onError = { _, _ ->
                    binding.loadingProgressBar.visibility = View.GONE
                }
            )
        }
    }

    private fun selectFirstAbility(abilities: List<AbilitiesResponse>) {
        val firstAbility = abilities.firstOrNull()
        firstAbility?.let { firstItem ->
            binding.tvAbilitiesName.text = firstItem.displayName
            binding.tvAbilitiesDesc.text = firstItem.description
            loadAbilityImage(firstItem.displayImage)
            abilitiesAdapter.setSelectedItem(0)
        }
    }
}