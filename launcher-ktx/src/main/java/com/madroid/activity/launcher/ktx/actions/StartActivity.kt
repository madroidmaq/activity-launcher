package com.madroid.activity.launcher.ktx.actions

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.startActivity

/**
 * extension for launch [ActivityResultContracts.StartActivityForResult]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchStartActivity(
    intent: Intent,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<ActivityResult>
) {
    ActivityLauncher.startActivity(activityResultRegistry).launch(intent, options, result)
}

/**
 * extension for launch [ActivityResultContracts.StartActivityForResult]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.awaitStartActivity(
    intent: Intent,
    options: ActivityOptionsCompat? = null,
): ActivityResult =
    ActivityLauncher.startActivity(activityResultRegistry).awaitLaunch(intent, options)

/**
 * extension for launch [ActivityResultContracts.StartActivityForResult]
 */
@Suppress("unused")
suspend fun Fragment.awaitStartActivity(
    intent: Intent,
    options: ActivityOptionsCompat? = null,
): ActivityResult =
    ActivityLauncher.startActivity(requireActivity().activityResultRegistry)
        .awaitLaunch(intent, options)
