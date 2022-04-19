package com.madroid.activity.result.launcher

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.TakeVideo]
 */
@Suppress("unused")
fun ActivityLauncher.takeVideo(
    registry: ActivityResultRegistry,
): Launcher<Uri, Bitmap?> = LauncherImpl(
    registry,
    ActivityResultContracts.TakeVideo()
)

/**
 * extension for launch [ActivityResultContracts.PickContact]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchTakeVideo(
    output: Uri,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Bitmap?>
) {
    ActivityLauncher.takeVideo(activityResultRegistry).launch(output, options, result)
}

/**
 * extension for launch [ActivityResultContracts.PickContact]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchTakeVideo(
    output: Uri,
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takeVideo(activityResultRegistry).launch(output, options)

/**
 * extension for launch [ActivityResultContracts.PickContact]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
fun Fragment.launchTakeVideo(
    output: Uri,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Bitmap?>
) {
    ActivityLauncher.takeVideo(requireActivity().activityResultRegistry)
        .launch(output, options, result)
}

/**
 * extension for launch [ActivityResultContracts.PickContact]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
suspend fun Fragment.launchTakeVideo(
    output: Uri,
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takeVideo(requireActivity().activityResultRegistry)
        .launch(output, options)
