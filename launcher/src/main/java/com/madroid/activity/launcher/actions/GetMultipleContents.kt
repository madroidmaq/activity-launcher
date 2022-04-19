package com.madroid.activity.launcher.actions

import android.net.Uri
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.GetMultipleContents]
 */
@Suppress("unused")
fun ActivityLauncher.getMultipleContents(registry: ActivityResultRegistry): Launcher<String, List<Uri>> =
    LauncherImpl(
        registry,
        ActivityResultContracts.GetMultipleContents()
    )
