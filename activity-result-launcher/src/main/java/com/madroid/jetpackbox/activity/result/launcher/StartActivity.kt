package com.madroid.jetpackbox.activity.result.launcher

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.jetpackbox.activity.result.ActivityLauncher
import com.madroid.jetpackbox.activity.result.ActivityLauncherImpl

/**
 * Wrapper for [ActivityResultContracts.StartActivityForResult]
 */
@Suppress("unused")
fun ActivityResultLauncher.startActivity(
    registry: ActivityResultRegistry,
): ActivityLauncher<Intent, ActivityResult> = ActivityLauncherImpl(
    registry,
    ActivityResultContracts.StartActivityForResult()
)

/**
 * extension for launch [ActivityResultContracts.StartActivityForResult]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchStartActivity(
    intent: Intent,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<ActivityResult>
) {
    ActivityResultLauncher.startActivity(activityResultRegistry).launch(intent, options, result)
}

/**
 * extension for launch [ActivityResultContracts.StartIntentSenderForResult]
 */
@Suppress("unused")
fun Fragment.launchTakeVideo(
    intent: Intent,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<ActivityResult>
) {
    ActivityResultLauncher.startActivity(requireActivity().activityResultRegistry)
        .launch(intent, options, result)
}
