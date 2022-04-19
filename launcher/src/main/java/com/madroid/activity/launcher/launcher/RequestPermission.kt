package com.madroid.activity.result.launcher

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.RequestPermission]
 */
@Suppress("unused")
fun ActivityLauncher.requestPermission(
    registry: ActivityResultRegistry,
): Launcher<String, Boolean> = LauncherImpl(
    registry,
    ActivityResultContracts.RequestPermission()
)

/**
 * extension for launch [ActivityResultContracts.RequestPermission]
 *
 * @param permission see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchRequestPermission(
    permission: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Boolean>
) {
    ActivityLauncher.requestPermission(activityResultRegistry)
        .launch(permission, options, result)
}

/**
 * extension for launch [ActivityResultContracts.RequestPermission]
 *
 * @param permission see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchRequestPermission(
    permission: String,
    options: ActivityOptionsCompat? = null,
): Boolean =
    ActivityLauncher.requestPermission(activityResultRegistry)
        .launch(permission, options)

/**
 * extension for launch [ActivityResultContracts.RequestPermission]
 *
 * @param permission see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
fun Fragment.launchRequestPermission(
    permission: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Boolean>
) {
    ActivityLauncher.requestPermission(requireActivity().activityResultRegistry)
        .launch(permission, options, result)
}

/**
 * extension for launch [ActivityResultContracts.RequestPermission]
 *
 * @param permission see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
suspend fun Fragment.launchRequestPermission(
    permission: String,
    options: ActivityOptionsCompat? = null,
): Boolean =
    ActivityLauncher.requestPermission(requireActivity().activityResultRegistry)
        .launch(permission, options)
