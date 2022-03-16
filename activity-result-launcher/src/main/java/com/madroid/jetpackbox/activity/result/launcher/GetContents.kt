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
 * Wrapper for [ActivityResultContracts.GetContent]
 */
@Suppress("unused")
fun ActivityResultLauncher.getContents(registry: ActivityResultRegistry): ActivityLauncher<String, Uri?> =
    ActivityLauncherImpl(
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
    ActivityResultLauncher.getContents(activityResultRegistry).launch(type, options, result)
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
): Uri? = ActivityResultLauncher.getContents(activityResultRegistry).launch(type, options)

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
    ActivityResultLauncher.getContents(requireActivity().activityResultRegistry)
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
): Uri? = ActivityResultLauncher.getContents(requireActivity().activityResultRegistry)
    .launch(type, options)
