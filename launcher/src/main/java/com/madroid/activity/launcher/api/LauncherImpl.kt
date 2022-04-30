package com.madroid.activity.launcher.api

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityOptionsCompat

internal class LauncherImpl<I, O>(
    private val registry: ActivityResultRegistry,
    private val contract: ActivityResultContract<I, O>
) : Launcher<I, O> {
    private var launcher: androidx.activity.result.ActivityResultLauncher<I>? = null
    override fun launch(
        input: I,
        options: ActivityOptionsCompat?,
        callback: ActivityResultCallback<O>
    ) {
        val key = "com.madroid#activity-result-launcher#${hashCode()}"
        registry.register(key, contract) {
            callback.onActivityResult(it)
            onResult()
        }.also {
            launcher = it
        }.launch(input, options)
    }

    private fun onResult() {
        launcher?.unregister()
    }

    override fun launch(input: I, callback: ActivityResultCallback<O>) {
        launch(input, null, callback)
    }
}
