package com.madroid.activity.result.launcher

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.RequestMultiplePermissions]
 */
@Suppress("unused")
fun ActivityLauncher.requestMultiplePermissions(
    registry: ActivityResultRegistry,
): Launcher<Array<String>, Map<String, Boolean>> = LauncherImpl(
    registry,
    ActivityResultContracts.RequestMultiplePermissions()
)

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
suspend fun androidx.activity.ComponentActivity.launchRequestMultiplePermissions(
    permissions: Array<String>,
    options: ActivityOptionsCompat? = null,
): Map<String, Boolean> =
    ActivityLauncher.requestMultiplePermissions(activityResultRegistry)
        .launch(permissions, options)

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
suspend fun Fragment.launchRequestMultiplePermissions(
    permissions: Array<String>,
    options: ActivityOptionsCompat? = null,
): Map<String, Boolean> =
    ActivityLauncher.requestMultiplePermissions(requireActivity().activityResultRegistry)
        .launch(permissions, options)
