package com.madroid.activity.launcher

import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

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
