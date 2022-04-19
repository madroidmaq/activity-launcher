package com.madroid.activity.result

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityOptionsCompat
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

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

    override suspend fun launch(input: I, options: ActivityOptionsCompat?): O =
        suspendCancellableCoroutine { continuation ->
            launch(input, options) { result ->
                continuation.resume(result)
            }
        }
}
