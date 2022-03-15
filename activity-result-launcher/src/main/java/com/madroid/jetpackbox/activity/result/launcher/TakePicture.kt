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
 * Wrapper for [ActivityResultContracts.TakePicture]
 */
@Suppress("unused")
fun ActivityResultLauncher.takePicture(
    registry: ActivityResultRegistry,
): ActivityLauncher<Uri, Boolean> = ActivityLauncherImpl(
    registry,
    ActivityResultContracts.TakePicture()
)

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
    ActivityResultLauncher.takePicture(activityResultRegistry).launch(output, options, result)
}

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
    ActivityResultLauncher.takePicture(requireActivity().activityResultRegistry)
        .launch(output, options, result)
}
