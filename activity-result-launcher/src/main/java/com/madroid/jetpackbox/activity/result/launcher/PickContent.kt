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
 * Wrapper for [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
fun ActivityResultLauncher.pickContact(registry: ActivityResultRegistry): ActivityLauncher<Void?, Uri?> =
    ActivityLauncherImpl(
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
    ActivityResultLauncher.pickContact(activityResultRegistry).launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchPickContact(
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityResultLauncher.pickContact(activityResultRegistry).launch(null, options)

/**
 * extension for launch [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
fun Fragment.launchPickContact(
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityResultLauncher.pickContact(requireActivity().activityResultRegistry)
        .launch(null, options, result)
}

/**
 * extension for launch [ActivityResultContracts.PickContact]
 */
@Suppress("unused")
suspend fun Fragment.launchPickContact(
    options: ActivityOptionsCompat? = null,
): Uri? =
    ActivityResultLauncher.pickContact(requireActivity().activityResultRegistry)
        .launch(null, options)
