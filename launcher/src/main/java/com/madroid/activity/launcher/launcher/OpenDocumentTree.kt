package com.madroid.activity.result.launcher

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.OpenDocumentTree]
 */
@Suppress("unused")
fun ActivityLauncher.openDocumentTree(registry: ActivityResultRegistry): Launcher<Uri?, Uri?> =
    LauncherImpl(
        registry,
        ActivityResultContracts.OpenDocumentTree()
    )

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
suspend fun androidx.activity.ComponentActivity.launchOpenDocumentTree(
    initialUri: Uri?,
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.openDocumentTree(activityResultRegistry).launch(initialUri, options)

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
suspend fun Fragment.launchOpenDocumentTree(
    initialUri: Uri?,
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.openDocumentTree(requireActivity().activityResultRegistry)
        .launch(initialUri, options)
