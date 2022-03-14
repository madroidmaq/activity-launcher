package com.madroid.jetpackbox.activity.result

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.core.app.ActivityOptionsCompat

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
