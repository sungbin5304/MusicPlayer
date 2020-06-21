package com.sungbin.musicplayer.ui.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sungbin.musicplayer.GlideApp
import com.sungbin.musicplayer.R
import com.sungbin.musicplayer.dto.SongItem
import com.sungbin.musicplayer.ui.fragment.BaseFragment
import com.sungbin.musicplayer.utils.SongUtils
import com.sungbin.recyclerviewadaptermaker.library.AdapterHelper
import com.sungbin.recyclerviewadaptermaker.library.options.Option
import com.sungbin.recyclerviewadaptermaker.library.options.Padding
import com.sungbin.sungbintool.ui.TagableRoundImageView
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : BaseFragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        AdapterHelper
            .with(rv_recently_played)
            .bindLayout(R.layout.layout_songs)
            .addViewBindListener { item, view, position ->
                val (name, artist, albumImageUrl, trackId, albumId) = item[position] as SongItem
                val albumImage = view.findViewById<TagableRoundImageView>(R.id.triv_song_cover)
                val songName = view.findViewById<TextView>(R.id.tv_song_name)
                val songArtist = view.findViewById<TextView>(R.id.tv_song_artist)

                GlideApp.with(context!!).load(albumImageUrl ?: R.drawable.sample_album_image).into(albumImage)
                songName += name
                songArtist += artist
            }
            .addOption(Option(null, Padding(0, 0, 50, 0)))
            .create(viewModel.songsItem)
        rv_recently_played.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.HORIZONTAL, false
        )

        AdapterHelper
            .with(rv_songs)
            .bindLayout(R.layout.layout_songs)
            .addViewBindListener { item, view, position ->
                val (name, artist, albumImageUrl, trackId, albumId) = item[position] as SongItem
                val albumImage = view.findViewById<TagableRoundImageView>(R.id.triv_song_cover)
                val songName = view.findViewById<TextView>(R.id.tv_song_name)
                val songArtist = view.findViewById<TextView>(R.id.tv_song_artist)

                val albumImageBitmap = SongUtils.getAlbumCoverBitmap(context!!, albumId, 100, 100)

                GlideApp.with(context!!).load(albumImageBitmap ?: R.drawable.sample_album_image).into(albumImage)
                songName += name
                songArtist += artist
            }
            .addOption(Option(null, Padding(0, 0, 50, 0)))
            .create(SongUtils.getAllAudioData(context!!))
        rv_songs.layoutManager = GridLayoutManager(context, 3)
    }

}