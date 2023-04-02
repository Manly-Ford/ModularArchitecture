package com.ts.base

import android.app.Application
import android.util.Log

private const val TAG = "ModuleMediator"

/**
 * @author tu_shuai
 * date  : 2023/4/2 12:41
 * desc  : 模块中介，用来模块之间的交互，每个模块的Application都来实现ModuleMediator.AppInitial这个接口初始化SDK等
 */
object ModuleMediator {

    /**
     * 模块的程序入口
     */
    const val CLASS_NAME_MESSAGE = "com.ts.message.MessageActivity"
    const val CLASS_NAME_SETTING = "com.ts.message.SettingActivity"
    const val CLASS_NAME_VIDEO = "com.ts.message.VideoActivity"

    /**
     * 模块的Application
     */
    private const val APP_MESSAGE_CLASS = "com.ts.message.MessageApplication"
    private const val APP_SETTING_CLASS = "com.ts.setting.SettingApplication"
    private const val APP_VIDEO_CLASS = "com.ts.video.VideoApplication"

    /**
     * 每一个模块的Application都实现此接口
     */
    interface AppInitial {
        fun initSDK(app: Application)
    }

    /**
     * 通过反射调用initSDK来初始化SDK操作
     */
    fun initSDK(app: Application) {
        val appClasses = arrayOf(APP_MESSAGE_CLASS, APP_SETTING_CLASS, APP_VIDEO_CLASS)
        for (claName in appClasses) {
            try {
                val clz = Class.forName(claName)
                val obj = clz.newInstance() as AppInitial
                obj.initSDK(app)
            } catch (e: ClassNotFoundException) {
                Log.e(TAG, "initSDK: Initialization failed, unable to find -> ${e.message}")
            }
        }
    }

}
