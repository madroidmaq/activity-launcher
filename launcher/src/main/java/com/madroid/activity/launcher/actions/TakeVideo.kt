package com.madroid.activity.launcher.actions

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.TakeVideo]
 */
@Suppress("unused")
fun ActivityLauncher.takeVideo(
    registry: ActivityResultRegistry,
): Launcher<Uri, Bitmap?> = LauncherImpl(
    registry,
    ActivityResultContracts.TakeVideo()
)
