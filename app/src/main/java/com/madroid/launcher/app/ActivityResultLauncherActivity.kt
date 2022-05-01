package com.madroid.launcher.app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.ktx.actions.awaitGetMultipleContents
import com.madroid.activity.launcher.ktx.actions.launchGetContents
import com.madroid.activity.launcher.ktx.actions.launchOpenDocument
import com.madroid.launcher.app.contracts.BleActivityResultContract
import com.madroid.launcher.app.contracts.enableBle
import com.madroid.launcher.app.databinding.ActivityResultLauncherBinding
import kotlinx.coroutines.launch

class ActivityResultLauncherActivity : AppCompatActivity() {

    companion object {
        const val TAG = "ActivityResultLauncher"
    }

    private lateinit var binding: ActivityResultLauncherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            createDocument.setOnClickListener {
                createDocument()
            }
            getContents.setOnClickListener {
                getContents()
            }
            getMultiContents.setOnClickListener {
                getMultiContents()
            }
            openDocument.setOnClickListener {
                openDocument()
            }
            openDocumentTree.setOnClickListener {
                openDocumentTree()
            }
            openMultiDocument.setOnClickListener {
                openMultiDocument()
            }
            pickContents.setOnClickListener {
                pickContents()
            }
            requestMultiplePermissions.setOnClickListener {
                requestMultiplePermissions()
            }
            requestPermission.setOnClickListener {
                requestPermission()
            }
            startActivity.setOnClickListener {
                startActivity()
            }
            startIntentSender.setOnClickListener {
                startIntentSender()
            }
            takePicture.setOnClickListener {
                takePicture()
            }
            takePicturePreview.setOnClickListener {
                takePicturePreview()
            }
            takeVideo.setOnClickListener {
                takeVideo()
            }
        }
    }

    private fun createDocument() {
        val title = "Title For Create Document"
        // create Document normal
        ActivityLauncher.createDocument(activityResultRegistry).launch(title) {
            Log.i(TAG, "createDocument result: $it")
        }
    }

    private fun getContents() {
        val type = "text/plain"
        // getContents with extension
        launchGetContents(type) {
            Log.i(TAG, "getContents result: $it")
        }
    }

    private fun getMultiContents() {
        lifecycleScope.launch {
            val type = "text/plain"
            val result = awaitGetMultipleContents(type)
            Log.i(TAG, "getMultiContents result: $result")
        }
    }

    private fun openDocument() {
        val mimeTypes = arrayOf("image/png", "audio/*")
        // getContents normal
        launchOpenDocument(mimeTypes) {
            Log.i(TAG, "OpenDocument result: $it")
        }
        // getContents with extension
        launchOpenDocument(mimeTypes) {
            Log.i(TAG, "OpenDocument result: $it")
        }
    }

    private fun openDocumentTree() {
        // TODO:
    }


    private fun openMultiDocument() {
        // TODO:
    }

    private fun pickContents() {
        // TODO:
    }

    private fun requestMultiplePermissions() {
        // TODO:
    }

    private fun requestPermission() {
        // TODO:
    }

    private fun startActivity() {
        // TODO:
    }

    private fun startIntentSender() {
        // TODO:
    }

    private fun takePicture() {
        // TODO:
    }

    private fun takePicturePreview() {
        // TODO:
    }

    private fun takeVideo() {
        // TODO:
    }

    private fun enableBle() {
        ActivityLauncher.startWithContract(activityResultRegistry, BleActivityResultContract()).launch(null) { isEnable ->

        }
    }

    private fun enableBleWithKtx() {
        ActivityLauncher.enableBle(activityResultRegistry) { isEnable ->

        }
    }
}
