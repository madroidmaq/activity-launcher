package com.madroid.activity.launcher.ext

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.takePicture

/**
 * extension for launch [ActivityResultContracts.TakePicture]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchTakePicture(
    output: Uri,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Boolean>
) {
    ActivityLauncher.takePicture(activityResultRegistry).launch(output, options, result)
}

/**
 * extension for launch [ActivityResultContracts.TakePicture]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchTakePicture(
    output: Uri,
    options: ActivityOptionsCompat? = null,
): Boolean =
    ActivityLauncher.takePicture(activityResultRegistry).launch(output, options)

/**
 * extension for launch [ActivityResultContracts.TakePicture]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
fun Fragment.launchTakePicture(
    output: Uri,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Boolean>
) {
    ActivityLauncher.takePicture(requireActivity().activityResultRegistry)
        .launch(output, options, result)
}

/**
 * extension for launch [ActivityResultContracts.TakePicture]
 *
 * @param output see [android.provider.MediaStore.EXTRA_OUTPUT]
 */
@Suppress("unused")
suspend fun Fragment.launchTakePicture(
    output: Uri,
    options: ActivityOptionsCompat? = null,
): Boolean =
    ActivityLauncher.takePicture(requireActivity().activityResultRegistry)
        .launch(output, options)
