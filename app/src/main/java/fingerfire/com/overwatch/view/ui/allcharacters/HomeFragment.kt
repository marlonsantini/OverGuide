package fingerfire.com.overwatch.view.ui.allcharacters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fingerfire.com.overwatch.R
import fingerfire.com.overwatch.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

/** Classe do fragment responsável pela apresentação da tela
 * Já com injeção de dependencia
 * Usando Observer para "escutar" as alterações na class de viewmodel
 * Fazendo chamada da view model para trazer lista de agentes
 * e tbm fazendo uso da palavra reservada viewmodel junto com o BY*/
class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerAgents()

        viewModel.getAgents()

    }

    private fun observerAgents() {
        viewModel.agentsLiveData.observe(viewLifecycleOwner) {
            binding.tvAgents.text = it.name[0].displayName

        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}