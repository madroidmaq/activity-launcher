package com.madroid.activity.launcher.ktx

import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityOptionsCompat
import com.madroid.activity.launcher.api.Launcher
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

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
suspend fun <I, O> Launcher<I, O>.awaitLaunch(input: I, options: ActivityOptionsCompat? = null): O =
    suspendCancellableCoroutine { continuation ->
        launch(input, options) { result ->
            continuation.resume(result)
        }
    }

