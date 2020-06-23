package com.sungbin.musicplayer.ui.fragment.main.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainTitleHolder(view: View): RecyclerView.ViewHolder(view) {
    val title: TextView = view.findViewById(android.R.id.text1)
}