package com.madroid.activity.result.launcher

import android.graphics.Bitmap
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
fun ActivityLauncher.takePicturePreview(
    registry: ActivityResultRegistry,
): Launcher<Void?, Bitmap?> = LauncherImpl(
    registry,
    ActivityResultContracts.TakePicturePreview()
)

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
suspend fun androidx.activity.ComponentActivity.launchTakePicturePreview(
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takePicturePreview(activityResultRegistry).launch(null, options)

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
suspend fun Fragment.launchTakePicturePreview(
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityLauncher.takePicturePreview(requireActivity().activityResultRegistry)
        .launch(null, options)
