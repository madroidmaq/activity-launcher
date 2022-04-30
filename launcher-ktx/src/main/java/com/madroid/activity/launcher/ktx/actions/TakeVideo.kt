package com.madroid.activity.launcher.ktx.actions

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.ktx.awaitLaunch

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
suspend fun androidx.activity.ComponentActivity.awaitTakeVideo(
    output: Uri,
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takeVideo(activityResultRegistry).awaitLaunch(output, options)

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
suspend fun Fragment.awaitTakeVideo(
    output: Uri,
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takeVideo(requireActivity().activityResultRegistry)
        .awaitLaunch(output, options)
