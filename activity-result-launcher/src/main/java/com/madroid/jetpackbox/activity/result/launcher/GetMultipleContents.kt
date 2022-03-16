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
 * Wrapper for [ActivityResultContracts.GetMultipleContents]
 */
@Suppress("unused")
fun ActivityResultLauncher.getMultipleContents(registry: ActivityResultRegistry): ActivityLauncher<String, List<Uri>> =
    ActivityLauncherImpl(
        registry,
        ActivityResultContracts.GetMultipleContents()
    )

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
    ActivityResultLauncher.getMultipleContents(activityResultRegistry).launch(type, options, result)
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
    ActivityResultLauncher.getMultipleContents(activityResultRegistry).launch(type, options)

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
    ActivityResultLauncher.getMultipleContents(requireActivity().activityResultRegistry)
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
    ActivityResultLauncher.getMultipleContents(requireActivity().activityResultRegistry)
        .launch(type, options)
