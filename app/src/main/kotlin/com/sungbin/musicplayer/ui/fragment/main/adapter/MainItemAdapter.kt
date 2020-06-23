package com.sungbin.musicplayer.ui.fragment.main.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.sungbin.musicplayer.R
import com.sungbin.musicplayer.dto.SongItem
import com.sungbin.musicplayer.ui.fragment.main.MainViewModel
import com.sungbin.musicplayer.ui.fragment.main.adapter.viewholder.MainRecentlyHolder
import com.sungbin.musicplayer.ui.fragment.main.adapter.viewholder.MainSongHolder
import com.sungbin.musicplayer.ui.fragment.main.adapter.viewholder.MainSpaceHolder
import com.sungbin.musicplayer.ui.fragment.main.adapter.viewholder.MainTitleHolder
import com.sungbin.recyclerviewadaptermaker.library.AdapterHelper
import com.sungbin.recyclerviewadaptermaker.library.options.Option
import com.sungbin.recyclerviewadaptermaker.library.options.Padding

class MainItemAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var viewModel: MainViewModel

    val viewTypes = arrayOf(
        0, // Space
        1, // Recently Title
        2, // Recently View
        1, // Songs Title
        3, // Songs View
        0 // Space
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val i = LayoutInflater.from(parent.context)
        return when (viewType) {
            0 -> MainSpaceHolder(i.inflate(R.layout.layout_space, parent, false))
            1 -> MainTitleHolder(i.inflate(R.layout.layout_list_header, parent, false))
            2 -> MainRecentlyHolder(i.inflate(R.layout.main_recently_list, parent, false))
            else -> MainSongHolder(i.inflate(R.layout.layout_songs, parent, false))
        }
    }

    // 3 = Songs View
    override fun getItemCount(): Int = (viewTypes.size-1) + viewModel.songSize()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MainTitleHolder -> setTitle(holder, position)
            is MainRecentlyHolder -> setRecently(holder, position)
            is MainSongHolder -> setSong(holder, position - (viewTypes.size-1)) // 3 = Songs View
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < viewTypes.size) viewTypes[position] else position
    }

    private fun setTitle(holder: MainTitleHolder, position: Int) {
        when (position) {
            1 -> {
                holder.title.setText(R.string.recently_played)
            }
            3 -> {
                holder.title.setText(R.string.song)
            }
        }
    }

    private fun setRecently(holder: MainRecentlyHolder, _position: Int) {
        val list = holder.list
        val songs = viewModel.recentlySongsItem.value ?: return
        AdapterHelper
            .with(list)
            .bindLayout(R.layout.layout_recently_songs)
            .addViewBindListener { item, view, position ->
                val (name, artist, albumImageUrl, trackId, albumId) = item[position] as SongItem
                val albumImage = view.findViewById<SimpleDraweeView>(R.id.triv_song_cover)
                val songName = view.findViewById<TextView>(R.id.tv_song_name)
                val songArtist = view.findViewById<TextView>(R.id.tv_song_artist)

                albumImage.setImageURI(Uri.parse(albumImageUrl), null)
                songName.text = name
                songArtist.text = artist
            }
            .addOption(Option(null, Padding(0, 0, 20, 0)))
            .create(ArrayList(songs))
        list.layoutManager = LinearLayoutManager(
            list.context, LinearLayoutManager.HORIZONTAL, false
        )
        list.setItemViewCacheSize(20)
        list.setHasFixedSize(true)
    }

    private fun setSong(holder: MainSongHolder, position: Int) {
        val item = viewModel.songsItem.value?.get(position) ?: return
        val (name, artist, albumImageUrl, trackId, albumId) = item
        holder.albumImage.setImageURI(albumImageUrl, null)
        holder.songName.text = name
        holder.songArtist.text = artist
    }
}