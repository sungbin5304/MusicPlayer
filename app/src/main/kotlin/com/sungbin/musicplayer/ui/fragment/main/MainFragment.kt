package com.sungbin.musicplayer.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import com.sungbin.musicplayer.R
import com.sungbin.musicplayer.ui.fragment.BaseFragment
import com.sungbin.musicplayer.ui.fragment.main.adapter.MainItemAdapter
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: FlexboxLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val context = requireContext()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewManager = FlexboxLayoutManager(context).apply {
            flexWrap = FlexWrap.WRAP
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
        }
        viewAdapter = MainItemAdapter().apply {
            viewModel = this@MainFragment.viewModel
        }

        if (viewModel.songsItem.value.isNullOrEmpty())
            viewModel.initSongs(context)
        if (viewModel.recentlySongsItem.value.isNullOrEmpty())
            viewModel.testRecentlySongs(context)

        list.setItemViewCacheSize(20)
        list.setHasFixedSize(true)
        list.adapter = viewAdapter
        list.layoutManager = viewManager


        /*
        AdapterHelper
            .with(rv_recently_played)
            .bindLayout(R.layout.layout_songs)
            .addViewBindListener { item, view, position ->
                val (name, artist, albumImageUrl, trackId, albumId) = item[position] as SongItem
                val albumImage = view.findViewById<SimpleDraweeView>(R.id.triv_song_cover)
                val songName = view.findViewById<TextView>(R.id.tv_song_name)
                val songArtist = view.findViewById<TextView>(R.id.tv_song_artist)

                albumImage.setImageURI(Uri.parse(albumImageUrl), null)
                songName += name
                songArtist += artist
            }
            .addOption(Option(null, Padding(0, 0, 50, 0)))
            .create(viewModel.songsItem)
        rv_recently_played.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )
        rv_recently_played.setItemViewCacheSize(20)
        rv_recently_played.setHasFixedSize(true)

        AdapterHelper
            .with(rv_songs)
            .bindLayout(R.layout.layout_songs)
            .addViewBindListener { item, view, position ->
                val (name, artist, albumImageUrl, trackId, albumId) = item[position] as SongItem
                val albumImage = view.findViewById<SimpleDraweeView>(R.id.triv_song_cover)
                val songName = view.findViewById<TextView>(R.id.tv_song_name)
                val songArtist = view.findViewById<TextView>(R.id.tv_song_artist)
                albumImage.setImageURI(albumImageUrl, null)
                songName += name
                songArtist += artist
            }
            .addOption(Option(null, Padding(0, 0, 0, 8)))
            .create(SongUtils.getAllAudioData(context))
        rv_songs.layoutManager = FlexboxLayoutManager(context).apply {
            flexWrap = FlexWrap.WRAP
            justifyContent = JustifyContent.SPACE_BETWEEN
            alignItems = AlignItems.CENTER
        }
        rv_songs.setItemViewCacheSize(20)
        rv_songs.setHasFixedSize(true)
         */

    }

}