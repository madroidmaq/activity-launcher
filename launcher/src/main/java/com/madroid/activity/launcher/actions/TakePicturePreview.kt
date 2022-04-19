package com.madroid.activity.launcher.actions

import android.graphics.Bitmap
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.TakePicturePreview]
 */
@Suppress("unused")
fun ActivityLauncher.takePicturePreview(
    registry: ActivityResultRegistry,
): Launcher<Void?, Bitmap?> = LauncherImpl(
    registry,
    ActivityResultContracts.TakePicturePreview()
)
