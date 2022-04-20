package com.madroid.activity.launcher.ext

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.getMultipleContents

/**
 * extension for launch [ActivityResultContracts.GetMultipleContents]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchGetMultipleContents(
    type: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<List<Uri>>
) {
    ActivityLauncher.getMultipleContents(activityResultRegistry).launch(type, options, result)
}

/**
 * extension for launch [ActivityResultContracts.GetMultipleContents]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchGetMultipleContents(
    type: String,
    options: ActivityOptionsCompat? = null,
): List<Uri> =
    ActivityLauncher.getMultipleContents(activityResultRegistry).launch(type, options)

/**
 * extension for launch [ActivityResultContracts.GetMultipleContents]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
fun Fragment.launchGetMultipleContents(
    type: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<List<Uri>>
) {
    ActivityLauncher.getMultipleContents(requireActivity().activityResultRegistry)
        .launch(type, options, result)
}

/**
 * extension for launch [ActivityResultContracts.GetMultipleContents]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
suspend fun Fragment.launchGetMultipleContents(
    type: String,
    options: ActivityOptionsCompat? = null,
): List<Uri> =
    ActivityLauncher.getMultipleContents(requireActivity().activityResultRegistry)
        .launch(type, options)