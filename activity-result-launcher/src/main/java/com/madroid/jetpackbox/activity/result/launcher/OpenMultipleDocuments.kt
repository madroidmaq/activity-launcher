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
 * Wrapper for [ActivityResultContracts.OpenMultipleDocuments]
 */
@Suppress("unused")
fun ActivityResultLauncher.openMultipleDocuments(registry: ActivityResultRegistry): ActivityLauncher<Array<String>, List<Uri>> =
    ActivityLauncherImpl(
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
    ActivityResultLauncher.openMultipleDocuments(activityResultRegistry)
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
    ActivityResultLauncher.openMultipleDocuments(activityResultRegistry).launch(input, options)

/**
 * extension for [ActivityResultContracts.OpenMultipleDocuments]
 */
@Suppress("unused")
fun Fragment.launchOpenDocumentTree(
    input: Array<String>,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<List<Uri>>
) {
    ActivityResultLauncher.openMultipleDocuments(requireActivity().activityResultRegistry)
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
    ActivityResultLauncher.openMultipleDocuments(requireActivity().activityResultRegistry)
        .launch(input, options)
