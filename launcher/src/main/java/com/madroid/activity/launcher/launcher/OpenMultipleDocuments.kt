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
 * Wrapper for [ActivityResultContracts.OpenMultipleDocuments]
 */
@Suppress("unused")
fun ActivityLauncher.openMultipleDocuments(registry: ActivityResultRegistry): Launcher<Array<String>, List<Uri>> =
    LauncherImpl(
        registry,
        ActivityResultContracts.OpenMultipleDocuments()
    )

/**
 * extension for [ActivityResultContracts.OpenMultipleDocuments]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchOpenDocumentTree(
    input: Array<String>,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<List<Uri>>
) {
    ActivityLauncher.openMultipleDocuments(activityResultRegistry)
        .launch(input, options, result)
}

/**
 * extension for [ActivityResultContracts.OpenMultipleDocuments]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchOpenDocumentTree(
    input: Array<String>,
    options: ActivityOptionsCompat? = null,
): List<Uri> =
    ActivityLauncher.openMultipleDocuments(activityResultRegistry).launch(input, options)

/**
 * extension for [ActivityResultContracts.OpenMultipleDocuments]
 */
@Suppress("unused")
fun Fragment.launchOpenDocumentTree(
    input: Array<String>,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<List<Uri>>
) {
    ActivityLauncher.openMultipleDocuments(requireActivity().activityResultRegistry)
        .launch(input, options, result)
}

/**
 * extension for [ActivityResultContracts.OpenMultipleDocuments]
 */
@Suppress("unused")
suspend fun Fragment.launchOpenDocumentTree(
    input: Array<String>,
    options: ActivityOptionsCompat? = null,
): List<Uri> =
    ActivityLauncher.openMultipleDocuments(requireActivity().activityResultRegistry)
        .launch(input, options)
