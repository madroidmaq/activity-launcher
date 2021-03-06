package com.madroid.activity.launcher.ktx.actions

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.ktx.awaitLaunch

/**
 * extension for launch [ActivityResultContracts.RequestMultiplePermissions]
 *
 * @param permissions see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchRequestMultiplePermissions(
    permissions: Array<String>,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Map<String, Boolean>>
) {
    ActivityLauncher.requestMultiplePermissions(activityResultRegistry)
        .launch(permissions, options, result)
}

/**
 * extension for launch [ActivityResultContracts.RequestMultiplePermissions]
 *
 * @param permissions see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.awaitRequestMultiplePermissions(
    permissions: Array<String>,
    options: ActivityOptionsCompat? = null,
): Map<String, Boolean> =
    ActivityLauncher.requestMultiplePermissions(activityResultRegistry)
        .awaitLaunch(permissions, options)

/**
 * extension for launch [ActivityResultContracts.RequestMultiplePermissions]
 *
 * @param permissions see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
fun Fragment.launchRequestMultiplePermissions(
    permissions: Array<String>,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Map<String, Boolean>>
) {
    ActivityLauncher.requestMultiplePermissions(requireActivity().activityResultRegistry)
        .launch(permissions, options, result)
}

/**
 * extension for launch [ActivityResultContracts.RequestMultiplePermissions]
 *
 * @param permissions see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
suspend fun Fragment.awaitRequestMultiplePermissions(
    permissions: Array<String>,
    options: ActivityOptionsCompat? = null,
): Map<String, Boolean> =
    ActivityLauncher.requestMultiplePermissions(requireActivity().activityResultRegistry)
        .awaitLaunch(permissions, options)
