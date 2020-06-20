package com.sungbin.musicplayer.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sungbin.musicplayer.R
import com.sungbin.musicplayer.ui.fragment.main.MainFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, MainFragment.newInstance())
                    .commitNow()
        }
    }
}