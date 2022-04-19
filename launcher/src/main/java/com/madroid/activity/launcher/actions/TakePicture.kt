package com.madroid.activity.launcher.actions

import android.net.Uri
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.TakePicture]
 */
@Suppress("unused")
fun ActivityLauncher.takePicture(
    registry: ActivityResultRegistry,
): Launcher<Uri, Boolean> = LauncherImpl(
    registry,
    ActivityResultContracts.TakePicture()
)
