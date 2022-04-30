package com.madroid.activity.launcher.ktx.actions

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.ktx.awaitLaunch

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
    ActivityLauncher.requestPermission(activityResultRegistry).launch(permission, options, result)
}

/**
 * extension for launch [ActivityResultContracts.RequestPermission]
 *
 * @param permission see [androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.EXTRA_PERMISSIONS]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.awaitRequestPermission(
    permission: String,
    options: ActivityOptionsCompat? = null,
): Boolean =
    ActivityLauncher.requestPermission(activityResultRegistry).awaitLaunch(permission, options)

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
suspend fun Fragment.awaitRequestPermission(
    permission: String,
    options: ActivityOptionsCompat? = null,
): Boolean =
    ActivityLauncher.requestPermission(requireActivity().activityResultRegistry)
        .awaitLaunch(permission, options)
