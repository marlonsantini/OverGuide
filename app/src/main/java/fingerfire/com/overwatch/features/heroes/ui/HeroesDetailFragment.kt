package fingerfire.com.overwatch.features.heroes.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector
import androidx.navigation.fragment.navArgs
import coil.load
import fingerfire.com.overwatch.databinding.FragmentHeroesDetailBinding
import fingerfire.com.overwatch.features.heroes.data.response.AbilitiesResponse
import fingerfire.com.overwatch.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overwatch.features.heroes.ui.adapter.AbilitiesAdapter
import fingerfire.com.overwatch.features.heroes.ui.adapter.HistoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HeroesDetailFragment : Fragment() {

    private lateinit var binding: FragmentHeroesDetailBinding
    private lateinit var abilitiesAdapter: AbilitiesAdapter
    private lateinit var historyAdapter: HistoryAdapter
    private val args: HeroesDetailFragmentArgs by navArgs()
    private val viewModel: HeroesDetailViewModel by viewModel()
    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHeroesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initBackButtonClickListener()

        // Inicialize o player aqui
        val trackSelector = DefaultTrackSelector(requireContext())
        player = ExoPlayer.Builder(requireContext())
            .setTrackSelector(trackSelector)
            .build()
    }

    private fun initViewModel() {
        viewModel.getHeroesDetail(args.id)
        viewModel.heroesDetailLiveData.observe(viewLifecycleOwner) { heroesDataResponse ->
            initUi(heroesDataResponse)
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
                abilitiesAdapter = AbilitiesAdapter(item.abilities, itemClick = { ability ->
                    binding.tvAbilitiesName.text = ability.displayName
                    binding.tvAbilitiesDesc.text = ability.description
                    preparePlayer(ability.displayVideo)
                    //loadAbilityImage(ability.displayImage)
                })
                rvAbilities.adapter = abilitiesAdapter
                selectFirstAbility(item.abilities)

                historyAdapter = HistoryAdapter(item.chapters, requireContext())
                tvDescHistory.text = item.history
                rvHistory.adapter = historyAdapter
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
            preparePlayer(firstItem.displayVideo)
//            loadAbilityImage(firstItem.displayImage)
            abilitiesAdapter.setSelectedItem(0)
        }
    }

    private fun preparePlayer(url: String) {
        player?.let { player ->
            player.clearMediaItems()
            player.setMediaItem(MediaItem.fromUri(Uri.parse(url)))
            player.prepare()
            player.play()
            binding.ivAbilitiesVideo.player = player
            player.repeatMode = Player.REPEAT_MODE_ONE
        }

        binding.ivAbilitiesVideo.useController = false

        binding.loadingProgressBar.visibility = View.VISIBLE

        player?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                when (state) {
                    Player.STATE_BUFFERING -> {
                        binding.loadingProgressBar.visibility = View.VISIBLE
                    }

                    Player.STATE_READY, Player.STATE_ENDED -> {
                        binding.loadingProgressBar.visibility = View.GONE
                    }

                    else -> {
                        // Outros estados do player
                    }
                }
            }
        })
    }

    override fun onStart() {
        super.onStart()
        player?.let { player ->
            val playerView = binding.ivAbilitiesVideo
            playerView.player = player
            player.playWhenReady = true
        }
    }

    override fun onResume() {
        super.onResume()
        player?.let { player ->
            val playerView = binding.ivAbilitiesVideo
            playerView.player = player
            player.playWhenReady = true
        }
    }

    override fun onPause() {
        super.onPause()
        player?.let { player ->
            player.playWhenReady = false
            val playerView = binding.ivAbilitiesVideo
            playerView.player = null
        }
    }

    override fun onStop() {
        super.onStop()
        player?.let { player ->
            player.playWhenReady = false
            val playerView = binding.ivAbilitiesVideo
            playerView.player = null
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.let { player ->
            player.release()
            this.player = null
        }
    }
}