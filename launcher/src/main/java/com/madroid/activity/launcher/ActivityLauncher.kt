package com.madroid.activity.launcher

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.madroid.activity.launcher.api.Launcher
import com.madroid.activity.launcher.api.LauncherImpl

object ActivityLauncher {

    /**
     * base activity result launcher with custom [ActivityResultContract]
     */
    @Suppress("unused")
    @JvmStatic
    fun <I, O> startWithContract(
        registry: ActivityResultRegistry,
        contract: ActivityResultContract<I, O>
    ): Launcher<I, O> = LauncherImpl(registry, contract)

    /**
     * Wrapper for [ActivityResultContracts.CreateDocument]
     */
    @Suppress("unused")
    @JvmStatic
    fun createDocument(registry: ActivityResultRegistry): Launcher<String, Uri?> =
        LauncherImpl(
            registry,
            ActivityResultContracts.CreateDocument()
        )

    /**
     * Wrapper for [ActivityResultContracts.GetContent]
     */
    @Suppress("unused")
    @JvmStatic
    fun getContents(registry: ActivityResultRegistry): Launcher<String, Uri?> =
        LauncherImpl(
            registry,
            ActivityResultContracts.GetContent()
        )

    /**
     * Wrapper for [ActivityResultContracts.GetMultipleContents]
     */
    @Suppress("unused")
    @JvmStatic
    fun getMultipleContents(registry: ActivityResultRegistry): Launcher<String, List<Uri>> =
        LauncherImpl(
            registry,
            ActivityResultContracts.GetMultipleContents()
        )

    /**
     * Wrapper for [ActivityResultContracts.OpenDocument]
     */
    @Suppress("unused")
    @JvmStatic
    fun openDocument(registry: ActivityResultRegistry): Launcher<Array<String>, Uri?> =
        LauncherImpl(
            registry,
            ActivityResultContracts.OpenDocument()
        )

    /**
     * Wrapper for [ActivityResultContracts.OpenDocumentTree]
     */
    @Suppress("unused")
    @JvmStatic
    fun openDocumentTree(registry: ActivityResultRegistry): Launcher<Uri?, Uri?> =
        LauncherImpl(
            registry,
            ActivityResultContracts.OpenDocumentTree()
        )

    /**
     * Wrapper for [ActivityResultContracts.OpenMultipleDocuments]
     */
    @Suppress("unused")
    @JvmStatic
    fun openMultipleDocuments(registry: ActivityResultRegistry): Launcher<Array<String>, List<Uri>> =
        LauncherImpl(
            registry,
            ActivityResultContracts.OpenMultipleDocuments()
        )

    /**
     * Wrapper for [ActivityResultContracts.PickContact]
     */
    @Suppress("unused")
    @JvmStatic
    fun pickContact(registry: ActivityResultRegistry): Launcher<Void?, Uri?> =
        LauncherImpl(
            registry,
            ActivityResultContracts.PickContact()
        )

    /**
     * Wrapper for [ActivityResultContracts.RequestMultiplePermissions]
     */
    @Suppress("unused")
    @JvmStatic
    fun requestMultiplePermissions(
        registry: ActivityResultRegistry,
    ): Launcher<Array<String>, Map<String, Boolean>> = LauncherImpl(
        registry,
        ActivityResultContracts.RequestMultiplePermissions()
    )

    /**
     * Wrapper for [ActivityResultContracts.RequestPermission]
     */
    @Suppress("unused")
    @JvmStatic
    fun requestPermission(
        registry: ActivityResultRegistry,
    ): Launcher<String, Boolean> = LauncherImpl(
        registry,
        ActivityResultContracts.RequestPermission()
    )


    /**
     * Wrapper for [ActivityResultContracts.StartActivityForResult]
     */
    @Suppress("unused")
    @JvmStatic
    fun startActivity(
        registry: ActivityResultRegistry,
    ): Launcher<Intent, ActivityResult> = LauncherImpl(
        registry,
        ActivityResultContracts.StartActivityForResult()
    )

    /**
     * Wrapper for [ActivityResultContracts.StartIntentSenderForResult]
     */
    @Suppress("unused")
    @JvmStatic
    fun startIntentSender(
        registry: ActivityResultRegistry,
    ): Launcher<IntentSenderRequest, ActivityResult> = LauncherImpl(
        registry,
        ActivityResultContracts.StartIntentSenderForResult()
    )

    /**
     * Wrapper for [ActivityResultContracts.TakePicture]
     */
    @Suppress("unused")
    @JvmStatic
    fun takePicture(
        registry: ActivityResultRegistry,
    ): Launcher<Uri, Boolean> = LauncherImpl(
        registry,
        ActivityResultContracts.TakePicture()
    )

    /**
     * Wrapper for [ActivityResultContracts.TakePicturePreview]
     */
    @Suppress("unused")
    @JvmStatic
    fun takePicturePreview(
        registry: ActivityResultRegistry,
    ): Launcher<Void?, Bitmap?> = LauncherImpl(
        registry,
        ActivityResultContracts.TakePicturePreview()
    )

    /**
     * Wrapper for [ActivityResultContracts.TakeVideo]
     */
    @Suppress("unused")
    @JvmStatic
    fun takeVideo(
        registry: ActivityResultRegistry,
    ): Launcher<Uri, Bitmap?> = LauncherImpl(
        registry,
        ActivityResultContracts.TakeVideo()
    )

}
