package com.madroid.activity.launcher.actions

import android.net.Uri
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

/**
 * Wrapper for [ActivityResultContracts.OpenDocumentTree]
 */
@Suppress("unused")
fun ActivityLauncher.openDocumentTree(registry: ActivityResultRegistry): Launcher<Uri?, Uri?> =
    LauncherImpl(
        registry,
        ActivityResultContracts.OpenDocumentTree()
    )