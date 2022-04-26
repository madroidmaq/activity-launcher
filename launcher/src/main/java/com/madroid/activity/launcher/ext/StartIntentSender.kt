package com.madroid.activity.launcher.ext

import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.startIntentSender

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
suspend fun androidx.activity.ComponentActivity.awaitStartIntentSender(
    output: IntentSenderRequest,
    options: ActivityOptionsCompat? = null,
): ActivityResult =
    ActivityLauncher.startIntentSender(activityResultRegistry).awaitLaunch(output, options)

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
suspend fun Fragment.awaitStartIntentSender(
    output: IntentSenderRequest,
    options: ActivityOptionsCompat? = null,
): ActivityResult =
    ActivityLauncher.startIntentSender(requireActivity().activityResultRegistry)
        .awaitLaunch(output, options)
