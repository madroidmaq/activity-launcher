package com.madroid.jetpackbox.activity.result.launcher

import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import com.madroid.jetpackbox.activity.result.ActivityLauncher
import com.madroid.jetpackbox.activity.result.ActivityLauncherImpl

object ActivityResultLauncher {

    /**
     * base activity result launcher with custom [ActivityResultContract]
     */
    @Suppress("unused")
    fun <I, O> startWithContract(
        registry: ActivityResultRegistry,
        contract: ActivityResultContract<I, O>
    ): ActivityLauncher<I, O> = ActivityLauncherImpl(registry, contract)
}
