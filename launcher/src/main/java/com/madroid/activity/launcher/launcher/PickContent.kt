package com.madroid.activity.result.launcher

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
fun ActivityLauncher.pickContact(registry: ActivityResultRegistry): Launcher<Void?, Uri?> =
    LauncherImpl(
        registry,
        ActivityResultContracts.PickContact()
    )

/**
 * extension for launch [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchPickContact(
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityLauncher.pickContact(activityResultRegistry).launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchPickContact(
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.pickContact(activityResultRegistry).launch(null, options)

/**
 * extension for launch [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
fun Fragment.launchPickContact(
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityLauncher.pickContact(requireActivity().activityResultRegistry)
        .launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
suspend fun Fragment.launchPickContact(
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.pickContact(requireActivity().activityResultRegistry)
        .launch(null, options)
