package com.madroid.activity.result.launcher

import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.result.Launcher
import com.madroid.activity.result.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.StartIntentSenderForResult]
 */
@Suppress("unused")
fun ActivityLauncher.startIntentSender(
    registry: ActivityResultRegistry,
): Launcher<IntentSenderRequest, ActivityResult> = LauncherImpl(
    registry,
    ActivityResultContracts.StartIntentSenderForResult()
)

/**
 * extension for launch [ActivityResultContracts.StartIntentSenderForResult]
 *
 * @param output see [androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchStartIntentSender(
    output: IntentSenderRequest,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<ActivityResult>
) {
    ActivityLauncher.startIntentSender(activityResultRegistry).launch(output, options, result)
}

/**
 * extension for launch [ActivityResultContracts.StartIntentSenderForResult]
 *
 * @param output see [androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchStartIntentSender(
    output: IntentSenderRequest,
    options: ActivityOptionsCompat? = null,
): ActivityResult =
    ActivityLauncher.startIntentSender(activityResultRegistry).launch(output, options)

/**
 * extension for launch [ActivityResultContracts.StartIntentSenderForResult]
 *
 * @param output see [androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST]
 */
@Suppress("unused")
fun Fragment.launchStartIntentSender(
    output: IntentSenderRequest,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<ActivityResult>
) {
    ActivityLauncher.startIntentSender(requireActivity().activityResultRegistry)
        .launch(output, options, result)
}

/**
 * extension for launch [ActivityResultContracts.StartIntentSenderForResult]
 *
 * @param output see [androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.EXTRA_INTENT_SENDER_REQUEST]
 */
@Suppress("unused")
suspend fun Fragment.launchStartIntentSender(
    output: IntentSenderRequest,
    options: ActivityOptionsCompat? = null,
): ActivityResult =
    ActivityLauncher.startIntentSender(requireActivity().activityResultRegistry)
        .launch(output, options)
