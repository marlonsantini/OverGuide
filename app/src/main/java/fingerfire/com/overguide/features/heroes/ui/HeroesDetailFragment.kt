package fingerfire.com.overguide.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.google.android.material.tabs.TabLayout
import fingerfire.com.overguide.R
import fingerfire.com.overguide.databinding.FragmentHeroesDetailBinding
import fingerfire.com.overguide.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overguide.features.heroes.ui.adapter.ViewPagerAdapter
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
        initViewModel()
    }

    private fun initViewModel() {
        viewModel.getHeroesDetail(args.id)
        viewModel.heroesDetailLiveData.observe(viewLifecycleOwner) { heroesDataResponse ->
            initUi(heroesDataResponse)
            setupViewPager(heroesDataResponse)
        }
    }

    private fun initUi(heroesDataResponse: HeroesDataResponse) {
        binding.apply {
            // Carregue as visualizações com os dados do herói
            ivHero.load(heroesDataResponse.fullPortraitV2)
            tvName.text = heroesDataResponse.displayName
        }
    }

    private fun setupViewPager(heroesDataResponse: HeroesDataResponse) {
        val viewPager: ViewPager2 = binding.viewPager
        val tabLayout: TabLayout = binding.tabLayout

        // Crie o adaptador para a ViewPager2
        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(
            HeroesProfileFragment(heroesDataResponse),
            "Perfil"
        ) // Substitua TabFragment1() pelo seu primeiro Fragment
        adapter.addFragment(
            HeroesAbilitiesFragment(heroesDataResponse),
            "Habilidades"
        ) // Substitua TabFragment2() pelo seu segundo Fragment
        adapter.addFragment(
            HeroesHistoryFragment(heroesDataResponse),
            "Historia"
        ) // Substitua TabFragment3() pelo seu terceiro Fragment

        // Defina o adaptador na ViewPager2
        viewPager.adapter = adapter

        // Conecte o TabLayout com a ViewPager2
        tabLayout.addTab(tabLayout.newTab().setText(R.string.profile))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.abilities))
        tabLayout.addTab(tabLayout.newTab().setText(R.string.history))

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.setCurrentItem(tab.position, true)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}