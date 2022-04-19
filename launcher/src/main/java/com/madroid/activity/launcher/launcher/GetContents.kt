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
 * Wrapper for [ActivityResultContracts.GetContent]
 */
@Suppress("unused")
fun ActivityLauncher.getContents(registry: ActivityResultRegistry): Launcher<String, Uri?> =
    LauncherImpl(
        registry,
        ActivityResultContracts.GetContent()
    )

/**
 * extension for launch [ActivityResultContracts.GetContent]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchGetContents(
    type: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityLauncher.getContents(activityResultRegistry).launch(type, options, result)
}

/**
 * extension for launch [ActivityResultContracts.GetContent]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchGetContents(
    type: String,
    options: ActivityOptionsCompat? = null,
): Uri? = ActivityLauncher.getContents(activityResultRegistry).launch(type, options)

/**
 * extension for launch [ActivityResultContracts.GetContent]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
fun Fragment.launchGetContents(
    type: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityLauncher.getContents(requireActivity().activityResultRegistry)
        .launch(type, options, result)
}

/**
 * extension for launch [ActivityResultContracts.GetContent]
 *
 * @param type MIME data type, see [android.content.Intent.setType]
 */
@Suppress("unused")
suspend fun Fragment.launchGetContents(
    type: String,
    options: ActivityOptionsCompat? = null,
): Uri? = ActivityLauncher.getContents(requireActivity().activityResultRegistry)
    .launch(type, options)
