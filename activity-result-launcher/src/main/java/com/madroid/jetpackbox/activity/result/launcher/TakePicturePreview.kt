package com.madroid.jetpackbox.activity.result.launcher

import android.graphics.Bitmap
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.jetpackbox.activity.result.ActivityLauncher
import com.madroid.jetpackbox.activity.result.ActivityLauncherImpl

/**
 * Wrapper for [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
fun ActivityResultLauncher.takePicturePreview(
    registry: ActivityResultRegistry,
): ActivityLauncher<Void?, Bitmap?> = ActivityLauncherImpl(
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
    ActivityResultLauncher.takePicturePreview(activityResultRegistry).launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchTakePicturePreview(
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityResultLauncher.takePicturePreview(activityResultRegistry).launch(null, options)

/**
 * extension for launch [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
fun Fragment.launchTakePicturePreview(
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Bitmap?>
) {
    ActivityResultLauncher.takePicturePreview(requireActivity().activityResultRegistry)
        .launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
suspend fun Fragment.launchTakePicturePreview(
    options: ActivityOptionsCompat? = null,
): Bitmap? =
    ActivityResultLauncher.takePicturePreview(requireActivity().activityResultRegistry)
        .launch(null, options)
