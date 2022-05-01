package com.madroid.launcher.app.contracts

import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import com.madroid.activity.launcher.ActivityLauncher


fun ActivityLauncher.enableBle(
    registry: ActivityResultRegistry,
    callback: ActivityResultCallback<Boolean>
) {
    startWithContract(registry, BleActivityResultContract()).launch(null, callback)
}