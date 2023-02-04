package fingerfire.com.overwatch.view.ui.allcharacters

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import fingerfire.com.overwatch.R
import fingerfire.com.overwatch.databinding.ActivityMainBinding
import fingerfire.com.overwatch.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {


    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        observerAgents()

        viewModel.getAgents()

    }

    private fun observerAgents() {
        viewModel.agentsLiveData.observe(viewLifecycleOwner) {
            binding.tvAgents.text = it.data[0].displayName

        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

}