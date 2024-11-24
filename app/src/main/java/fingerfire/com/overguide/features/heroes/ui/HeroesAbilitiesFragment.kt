package fingerfire.com.overguide.features.heroes.ui

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
import androidx.recyclerview.widget.GridLayoutManager
import fingerfire.com.overguide.databinding.TabAbilitiesBinding
import fingerfire.com.overguide.features.heroes.data.response.AbilitiesResponse
import fingerfire.com.overguide.features.heroes.data.response.HeroesDataResponse
import fingerfire.com.overguide.features.heroes.ui.adapter.AbilitiesAdapter

class HeroesAbilitiesFragment(private val heroesDataResponse: HeroesDataResponse) : Fragment() {

    private lateinit var binding: TabAbilitiesBinding
    private lateinit var abilitiesAdapter: AbilitiesAdapter
    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = TabAbilitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()

        // Inicialize o player aqui
        val trackSelector = DefaultTrackSelector(requireContext())
        player = ExoPlayer.Builder(requireContext())
            .setTrackSelector(trackSelector)
            .build()
    }

    private fun initUi() {
        binding.apply {
            heroesDataResponse.let { item ->
                abilitiesAdapter = AbilitiesAdapter(item.abilities, itemClick = { ability ->
                    binding.tvAbilitiesName.text = ability.displayName
                    binding.tvAbilitiesDesc.text = ability.description
                    preparePlayer(ability.displayVideo)
                    //loadAbilityImage(ability.displayImage)
                })
                initRecyclerView()
                rvAbilities.adapter = abilitiesAdapter
                //selectFirstAbility(item.abilities)

            }
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
        binding.ivAbilitiesVideo.visibility = View.VISIBLE
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

    private fun initRecyclerView() {
        binding.rvAbilities.layoutManager =
            GridLayoutManager(activity, 4)
        binding.rvAbilities.setHasFixedSize(true)
        binding.rvAbilities.onFlingListener = null
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