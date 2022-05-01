package com.madroid.launcher.app.contracts

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

/**
 * 开启蓝牙
 * https://developer.android.com/guide/topics/connectivity/bluetooth#SettingUp
 */
class BleActivityResultContract : ActivityResultContract<Unit?, Boolean>() {
    override fun createIntent(context: Context, input: Unit?): Intent {
        return Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Boolean {
        return resultCode == Activity.RESULT_OK
    }
}
