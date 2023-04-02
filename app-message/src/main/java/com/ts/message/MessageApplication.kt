package com.ts.message

import android.app.Application
import android.util.Log
import com.ts.base.ModuleMediator

/**
 * @author tu_shuai
 * date  : 2023/4/2 14:52
 * desc  :
 */
class MessageApplication : ModuleMediator.AppInitial {

    override fun initSDK(app: Application) {
        Log.i("TAG", "initSDK: MessageApplication")
    }

}