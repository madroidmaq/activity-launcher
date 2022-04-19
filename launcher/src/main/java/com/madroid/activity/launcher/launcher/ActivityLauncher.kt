package com.madroid.activity.result.launcher

import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

object ActivityLauncher {

    /**
     * base activity result launcher with custom [ActivityResultContract]
     */
    @Suppress("unused")
    fun <I, O> startWithContract(
        registry: ActivityResultRegistry,
        contract: ActivityResultContract<I, O>
    ): Launcher<I, O> = LauncherImpl(registry, contract)
}
