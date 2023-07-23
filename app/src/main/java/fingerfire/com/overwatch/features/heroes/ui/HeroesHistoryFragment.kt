package fingerfire.com.overwatch.features.heroes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fingerfire.com.overwatch.databinding.TabHistoryBinding
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.ui.adapter.HistoryAdapter

class HeroesHistoryFragment(private val heroesDataResponse: HeroesDataResponse) : Fragment() {

    private lateinit var binding: TabHistoryBinding
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TabHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
    }

    private fun initUi() {
        binding.apply {
            heroesDataResponse.let { item ->
                historyAdapter = HistoryAdapter(item.chapters, requireContext())
                tvDescHistory.text = item.history
                rvHistory.adapter = historyAdapter
            }
        }
    }
}