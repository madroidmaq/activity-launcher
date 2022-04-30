package com.madroid.activity.launcher.ktx.actions

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.openMultipleDocuments

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
suspend fun androidx.activity.ComponentActivity.awaitOpenDocumentTree(
    input: Array<String>,
    options: ActivityOptionsCompat? = null,
): List<Uri> =
    ActivityLauncher.openMultipleDocuments(activityResultRegistry).awaitLaunch(input, options)

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
suspend fun Fragment.awaitOpenDocumentTree(
    input: Array<String>,
    options: ActivityOptionsCompat? = null,
): List<Uri> =
    ActivityLauncher.openMultipleDocuments(requireActivity().activityResultRegistry)
        .awaitLaunch(input, options)
