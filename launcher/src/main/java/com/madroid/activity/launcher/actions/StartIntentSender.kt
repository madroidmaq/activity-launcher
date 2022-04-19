package com.madroid.activity.launcher.actions

import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

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
