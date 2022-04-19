package com.madroid.activity.launcher.actions

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.StartActivityForResult]
 */
@Suppress("unused")
fun ActivityLauncher.startActivity(
    registry: ActivityResultRegistry,
): Launcher<Intent, ActivityResult> = LauncherImpl(
    registry,
    ActivityResultContracts.StartActivityForResult()
)
