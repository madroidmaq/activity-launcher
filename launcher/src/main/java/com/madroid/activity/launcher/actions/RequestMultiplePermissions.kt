package com.madroid.activity.launcher.actions

import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.RequestMultiplePermissions]
 */
@Suppress("unused")
fun ActivityLauncher.requestMultiplePermissions(
    registry: ActivityResultRegistry,
): Launcher<Array<String>, Map<String, Boolean>> = LauncherImpl(
    registry,
    ActivityResultContracts.RequestMultiplePermissions()
)
