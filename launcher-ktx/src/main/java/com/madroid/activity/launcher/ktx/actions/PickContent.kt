package com.madroid.activity.launcher.ktx.actions

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.ktx.awaitLaunch

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
suspend fun androidx.activity.ComponentActivity.awaitPickContact(
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.pickContact(activityResultRegistry).awaitLaunch(null, options)

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
suspend fun Fragment.awaitPickContact(
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityLauncher.pickContact(requireActivity().activityResultRegistry)
        .awaitLaunch(null, options)
