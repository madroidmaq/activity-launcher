package com.madroid.activity.launcher.ext

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.openDocumentTree

/**
 * extension for [ActivityResultContracts.OpenDocumentTree]
 *
 * @param initialUri see [android.provider.DocumentsContract.EXTRA_INITIAL_URI]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchOpenDocumentTree(
    initialUri: Uri?,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityLauncher.openDocumentTree(activityResultRegistry)
        .launch(initialUri, options, result)
}

/**
 * extension for [ActivityResultContracts.OpenDocumentTree]
 *
 * @param initialUri see [android.provider.DocumentsContract.EXTRA_INITIAL_URI]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.awaitOpenDocumentTree(
    initialUri: Uri?,
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.openDocumentTree(activityResultRegistry).awaitLaunch(initialUri, options)

/**
 * extension for [ActivityResultContracts.OpenDocumentTree]
 *
 * @param initialUri see [android.provider.DocumentsContract.EXTRA_INITIAL_URI]
 */
@Suppress("unused")
fun Fragment.launchOpenDocumentTree(
    initialUri: Uri?,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityLauncher.openDocumentTree(requireActivity().activityResultRegistry)
        .launch(initialUri, options, result)
}

/**
 * extension for [ActivityResultContracts.OpenDocumentTree]
 *
 * @param initialUri see [android.provider.DocumentsContract.EXTRA_INITIAL_URI]
 */
@Suppress("unused")
suspend fun Fragment.awaitOpenDocumentTree(
    initialUri: Uri?,
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.openDocumentTree(requireActivity().activityResultRegistry)
        .awaitLaunch(initialUri, options)
