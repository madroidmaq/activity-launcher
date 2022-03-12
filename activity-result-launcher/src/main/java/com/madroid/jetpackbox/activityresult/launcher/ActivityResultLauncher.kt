package com.madroid.jetpackbox.activityresult.launcher

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityOptionsCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.coroutineScope
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

interface ActivityResultLauncher<I, O> {

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

internal class ActivityResultLauncherImpl<I, O>(
    private val registry: ActivityResultRegistry,
    private val lifecycleOwner: LifecycleOwner,
    private val contract: ActivityResultContract<I, O>
) : ActivityResultLauncher<I, O> {

    override fun launch(
        input: I,
        options: ActivityOptionsCompat?,
        callback: ActivityResultCallback<O>
    ) {
        lifecycleOwner.lifecycle.coroutineScope.launchWhenStarted {
            registry.register(
                "com.madroid.jetpackbox#activity-result-launcher#${hashCode()}",
                lifecycleOwner,
                contract,
                callback
            ).launch(input, options)
        }
    }

    override suspend fun launch(input: I, options: ActivityOptionsCompat?): O =
        suspendCancellableCoroutine { conti ->
            launch(input, options) { result ->
                conti.resume(result)
            }
        }
}
