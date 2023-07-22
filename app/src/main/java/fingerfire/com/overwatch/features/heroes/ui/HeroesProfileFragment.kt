package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fingerfire.com.overwatch.databinding.TabProfileBinding
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse

class HeroesProfileFragment(private val heroesDataResponse: HeroesDataResponse) : Fragment() {

    private lateinit var binding: TabProfileBinding

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
        }
    }
}