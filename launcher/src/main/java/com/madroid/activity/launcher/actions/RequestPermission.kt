package com.madroid.activity.launcher.actions

import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.RequestPermission]
 */
@Suppress("unused")
fun ActivityLauncher.requestPermission(
    registry: ActivityResultRegistry,
): Launcher<String, Boolean> = LauncherImpl(
    registry,
    ActivityResultContracts.RequestPermission()
)
