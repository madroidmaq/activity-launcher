package com.madroid.jetpackbox.activity.result

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityOptionsCompat
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

interface ActivityLauncher<I, O> {

    /**
     * API Wrapper For  [androidx.activity.result.ActivityResultLauncher.launch].
     *
     * @param input the input required to execute an [ActivityResultContract].
     * @param options Additional options for how the Activity should be started, default value is null.
     * @param callback the activity result callback.
     *
     * @throws android.content.ActivityNotFoundException
     */
    fun launch(
        input: I,
        options: ActivityOptionsCompat? = null,
        callback: ActivityResultCallback<O>
    )

    /**
     * API Wrapper For  [androidx.activity.result.ActivityResultLauncher.launch] use suspend fun.
     *
     * @param input the input required to execute an [ActivityResultContract].
     * @param options Additional options for how the Activity should be started, default value is null.
     *
     * @return the activity result value.
     *
     * @throws android.content.ActivityNotFoundException
     */
    suspend fun launch(input: I, options: ActivityOptionsCompat? = null): O
}

internal class ActivityLauncherImpl<I, O>(
    private val registry: ActivityResultRegistry,
    private val contract: ActivityResultContract<I, O>
) : ActivityLauncher<I, O> {

    private var launcher: androidx.activity.result.ActivityResultLauncher<I>? = null
    override fun launch(
        input: I,
        options: ActivityOptionsCompat?,
        callback: ActivityResultCallback<O>
    ) {
        val key = "com.madroid.jetpackbox#activity-result-launcher#${hashCode()}"
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