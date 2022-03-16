package com.madroid.jetpackbox.app.launcher

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.madroid.jetpackbox.activity.result.launcher.ActivityResultLauncher
import com.madroid.jetpackbox.activity.result.launcher.createDocument
import com.madroid.jetpackbox.activity.result.launcher.getContents
import com.madroid.jetpackbox.activity.result.launcher.getMultipleContents
import com.madroid.jetpackbox.activity.result.launcher.launchCreateDocument
import com.madroid.jetpackbox.activity.result.launcher.launchGetContents
import com.madroid.jetpackbox.activity.result.launcher.launchGetMultipleContents
import com.madroid.jetpackbox.activity.result.launcher.launchOpenDocument
import com.madroid.jetpackbox.activity.result.launcher.openDocument
import com.madroid.jetpackbox.app.databinding.ActivityResultLauncherBinding

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
        ActivityResultLauncher.createDocument(activityResultRegistry).launch(title) {
            Log.i(TAG, "createDocument result: $it")
        }
        // create Document with extension
        launchCreateDocument(title) {
            Log.i(TAG, "createDocument result: $it")
        }
    }

    private fun getContents() {
        val type = "text/plain"
        // getContents normal
        ActivityResultLauncher.getContents(activityResultRegistry).launch(type) {
            Log.i(TAG, "getContents result: $it")
        }
        // getContents with extension
        launchGetContents(type) {
            Log.i(TAG, "getContents result: $it")
        }
    }

    private fun getMultiContents() {
        val type = "text/plain"
        // getContents normal
        ActivityResultLauncher.getMultipleContents(activityResultRegistry).launch(type) {
            Log.i(TAG, "getMultipleContents result: $it")
        }
        // getContents with extension
        launchGetMultipleContents(type) {
            Log.i(TAG, "getMultipleContents result: $it")
        }
    }

    private fun openDocument() {
        val mimeTypes = arrayOf("image/png", "audio/*")
        // getContents normal
        ActivityResultLauncher.openDocument(activityResultRegistry).launch(mimeTypes) {
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
}
