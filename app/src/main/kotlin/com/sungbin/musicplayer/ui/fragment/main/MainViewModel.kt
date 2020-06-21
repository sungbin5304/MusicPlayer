package com.sungbin.musicplayer.ui.fragment.main

import androidx.lifecycle.ViewModel
import com.sungbin.musicplayer.dto.SongItem

class MainViewModel : ViewModel() {
    val songsItem = arrayListOf( //테스트용, SonsItem id에 기본값으로 = 0L 넣을려고 했는데 어차피 테스트용으로 쓸거라 걍 안함
        SongItem("Sexual", "Neiked", "https://musicmeta-phinf.pstatic.net/album/000/662/662857.jpg?type=r204Fll&v=20200218185711", 0L, 0L),
        SongItem("Sexual", "Neiked", "https://musicmeta-phinf.pstatic.net/album/000/662/662857.jpg?type=r204Fll&v=20200218185711", 0L, 0L),
        SongItem("Sexual", "Neiked", "https://musicmeta-phinf.pstatic.net/album/000/662/662857.jpg?type=r204Fll&v=20200218185711", 0L, 0L),
        SongItem("Sexual", "Neiked", "htps://musicmeta-phinf.pstatic.net/album/000/662/662857.jpg?type=r204Fll&v=20200218185711", 0L, 0L)
    )


}