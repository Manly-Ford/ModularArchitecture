package com.ts.setting.debug

import android.app.Application
import com.ts.setting.SettingApplication

/**
 * @author tu_shuai
 * date  : 2023/4/2 14:56
 * desc  :
 */
class DebugSettingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SettingApplication().initSDK(this)
    }

}