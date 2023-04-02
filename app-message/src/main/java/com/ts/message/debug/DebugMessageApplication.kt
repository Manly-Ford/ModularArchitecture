package com.ts.message.debug

import android.app.Application
import com.ts.message.MessageApplication

/**
 * @author tu_shuai
 * date  : 2023/4/2 15:01
 * desc  :
 */
class DebugMessageApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MessageApplication().initSDK(this)
    }

}