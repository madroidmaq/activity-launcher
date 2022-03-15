package com.madroid.jetpackbox.activity.result.launcher

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.jetpackbox.activity.result.ActivityLauncher
import com.madroid.jetpackbox.activity.result.ActivityLauncherImpl

/**
 * Wrapper for [ActivityResultContracts.OpenDocument]
 */
@Suppress("unused")
fun ActivityResultLauncher.openDocument(registry: ActivityResultRegistry): ActivityLauncher<Array<String>, Uri?> =
    ActivityLauncherImpl(
        registry,
        ActivityResultContracts.OpenDocument()
    )

/**
 * extension for [ActivityResultContracts.OpenDocument]
 *
 * @param mimeTypes see [android.content.Intent.EXTRA_MIME_TYPES]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchOpenDocument(
    mimeTypes: Array<String>,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityResultLauncher.openDocument(activityResultRegistry)
        .launch(mimeTypes, options, result)
}

/**
 * extension for [ActivityResultContracts.OpenDocument]
 *
 * @param mimeTypes see [android.content.Intent.EXTRA_MIME_TYPES]
 */
@Suppress("unused")
fun Fragment.launchOpenDocument(
    mimeTypes: Array<String>,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityResultLauncher.openDocument(requireActivity().activityResultRegistry)
        .launch(mimeTypes, options, result)
}
