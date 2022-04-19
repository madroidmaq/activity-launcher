package com.madroid.activity.launcher.actions

import android.net.Uri
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.OpenDocument]
 */
@Suppress("unused")
fun ActivityLauncher.openDocument(registry: ActivityResultRegistry): Launcher<Array<String>, Uri?> =
    LauncherImpl(
        registry,
        ActivityResultContracts.OpenDocument()
    )
