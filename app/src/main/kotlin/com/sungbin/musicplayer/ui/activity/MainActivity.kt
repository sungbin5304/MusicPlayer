package com.sungbin.musicplayer.ui.activity

import android.Manifest
import android.os.Bundle
import com.sungbin.musicplayer.R
import com.sungbin.musicplayer.ui.fragment.main.MainFragment
import com.sungbin.sungbintool.PermissionUtils

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, MainFragment.newInstance())
            .commitNow()

        PermissionUtils.request(this, "권한내놔", arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE))
    }
}