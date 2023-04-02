package com.ts.modular

import android.app.Application
import com.ts.base.ModuleMediator

/**
 * @author tu_shuai
 * date  : 2023/4/2 12:26
 * desc  :
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ModuleMediator.initSDK(this)
    }

}