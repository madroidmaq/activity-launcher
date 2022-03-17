package com.madroid.jetpackbox.activity.result.launcher

import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.jetpackbox.activity.result.ActivityLauncher
import com.madroid.jetpackbox.activity.result.ActivityLauncherImpl

/**
 * Wrapper for [ActivityResultContracts.StartIntentSenderForResult]
 */
@Suppress("unused")
fun ActivityResultLauncher.startIntentSender(
    registry: ActivityResultRegistry,
): ActivityLauncher<IntentSenderRequest, ActivityResult> = ActivityLauncherImpl(
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
    ActivityResultLauncher.startIntentSender(activityResultRegistry).launch(output, options, result)
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
    ActivityResultLauncher.startIntentSender(activityResultRegistry).launch(output, options)

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
    ActivityResultLauncher.startIntentSender(requireActivity().activityResultRegistry)
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
    ActivityResultLauncher.startIntentSender(requireActivity().activityResultRegistry)
        .launch(output, options)