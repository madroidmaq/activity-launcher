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
 * Wrapper for [ActivityResultContracts.OpenDocumentTree]
 */
@Suppress("unused")
fun ActivityResultLauncher.openDocumentTree(registry: ActivityResultRegistry): ActivityLauncher<Uri?, Uri?> =
    ActivityLauncherImpl(
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
    ActivityResultLauncher.openDocumentTree(activityResultRegistry)
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
    ActivityResultLauncher.openDocumentTree(activityResultRegistry).launch(initialUri, options)

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
    ActivityResultLauncher.openDocumentTree(requireActivity().activityResultRegistry)
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
    ActivityResultLauncher.openDocumentTree(requireActivity().activityResultRegistry)
        .launch(initialUri, options)
