package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import fingerfire.com.overwatch.databinding.TabProfileBinding
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.ui.adapter.ComboAdapter
import fingerfire.com.overwatch.features.heroes.ui.adapter.WeakAdapter

class HeroesProfileFragment(private val heroesDataResponse: HeroesDataResponse) : Fragment() {

    private lateinit var binding: TabProfileBinding
    private lateinit var comboAdapter: ComboAdapter
    private lateinit var weakAdapter: WeakAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TabProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        binding.apply {
            // Carregue as visualizações com os dados do herói
            tvDesc.text = heroesDataResponse.description
            tvNameReal.text = heroesDataResponse.developerName
            tvBase.text = heroesDataResponse.location
            tvRole.text = heroesDataResponse.role.displayName
            tvLife.text = heroesDataResponse.life
            tvShield.text = heroesDataResponse.shield

            heroesDataResponse.let { item ->
                initRecyclerView()

                comboAdapter = ComboAdapter(item.combo)
                rvCombo.adapter = comboAdapter

                weakAdapter = WeakAdapter(item.weak)
                rvWeak.adapter = weakAdapter
            }
        }
    }

    private fun initRecyclerView() {
        binding.rvCombo.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCombo.setHasFixedSize(true)
        binding.rvCombo.onFlingListener = null

        binding.rvWeak.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.rvWeak.setHasFixedSize(true)
        binding.rvWeak.onFlingListener = null
    }
}