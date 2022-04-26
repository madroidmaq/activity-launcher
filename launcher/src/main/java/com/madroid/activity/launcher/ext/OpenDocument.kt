package com.madroid.activity.launcher.ext

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.openDocument

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
    ActivityLauncher.openDocument(activityResultRegistry)
        .launch(mimeTypes, options, result)
}

/**
 * extension for [ActivityResultContracts.OpenDocument]
 *
 * @param mimeTypes see [android.content.Intent.EXTRA_MIME_TYPES]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.awaitOpenDocument(
    mimeTypes: Array<String>,
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.openDocument(activityResultRegistry).awaitLaunch(mimeTypes, options)

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
    ActivityLauncher.openDocument(requireActivity().activityResultRegistry)
        .launch(mimeTypes, options, result)
}

/**
 * extension for [ActivityResultContracts.OpenDocument]
 *
 * @param mimeTypes see [android.content.Intent.EXTRA_MIME_TYPES]
 */
@Suppress("unused")
suspend fun Fragment.awaitOpenDocument(
    mimeTypes: Array<String>,
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.openDocument(requireActivity().activityResultRegistry)
        .awaitLaunch(mimeTypes, options)
