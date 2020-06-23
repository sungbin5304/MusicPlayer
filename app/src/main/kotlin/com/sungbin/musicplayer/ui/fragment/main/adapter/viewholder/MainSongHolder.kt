package com.sungbin.musicplayer.ui.fragment.main.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.sungbin.musicplayer.R

class MainSongHolder(view: View): RecyclerView.ViewHolder(view) {
    val albumImage: SimpleDraweeView = view.findViewById(R.id.triv_song_cover)
    val songName: TextView = view.findViewById(R.id.tv_song_name)
    val songArtist: TextView = view.findViewById(R.id.tv_song_artist)
}