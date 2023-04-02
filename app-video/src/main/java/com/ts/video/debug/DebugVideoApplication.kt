package com.ts.video.debug

import android.app.Application
import com.ts.video.VideoApplication

/**
 * @author tu_shuai
 * date  : 2023/4/2 15:02
 * desc  :
 */
class DebugVideoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        VideoApplication().initSDK(this)
    }

}