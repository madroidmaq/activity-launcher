package com.madroid.activity.launcher.ext

import android.graphics.Bitmap
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.takePicturePreview

/**
 * extension for launch [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchTakePicturePreview(
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Bitmap?>
) {
    ActivityLauncher.takePicturePreview(activityResultRegistry).launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.awaitTakePicturePreview(
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takePicturePreview(activityResultRegistry).awaitLaunch(null, options)

/**
 * extension for launch [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
fun Fragment.launchTakePicturePreview(
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Bitmap?>
) {
    ActivityLauncher.takePicturePreview(requireActivity().activityResultRegistry)
        .launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
suspend fun Fragment.awaitTakePicturePreview(
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takePicturePreview(requireActivity().activityResultRegistry)
        .awaitLaunch(null, options)
