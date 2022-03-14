package com.madroid.jetpackbox.activity.result

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

object ActivityResultLauncher {

    /**
     * base activity result launcher with custom [ActivityResultContract]
     */
    @Suppress("unused")
    fun <I, O> startWithContract(
        registry: ActivityResultRegistry,
        contract: ActivityResultContract<I, O>
    ): ActivityLauncher<I, O> = ActivityLauncherImpl(registry, contract)

    /**
     * Wrapper for [ActivityResultContracts.StartActivityForResult]
     */
    @JvmStatic
    @Suppress("unused")
    fun startWithIntent(
        registry: ActivityResultRegistry,
    ): ActivityLauncher<Intent, ActivityResult> = ActivityLauncherImpl(
        registry,
        ActivityResultContracts.StartActivityForResult()
    )

    /**
     * Wrapper for [ActivityResultContracts.StartIntentSenderForResult]
     */
    @Suppress("unused")
    fun startIntentSender(
        registry: ActivityResultRegistry,
    ): ActivityLauncher<IntentSenderRequest, ActivityResult> = ActivityLauncherImpl(
        registry,
        ActivityResultContracts.StartIntentSenderForResult()
    )

    /**
     * Wrapper for [ActivityResultContracts.RequestMultiplePermissions]
     */
    @Suppress("unused")
    fun requestMultiplePermissions(
        registry: ActivityResultRegistry,
    ): ActivityLauncher<Array<String>, Map<String, Boolean>> = ActivityLauncherImpl(
        registry,
        ActivityResultContracts.RequestMultiplePermissions()
    )

    /**
     * Wrapper for [ActivityResultContracts.RequestPermission]
     */
    @Suppress("unused")
    fun requestPermission(
        registry: ActivityResultRegistry,
    ): ActivityLauncher<String, Boolean> = ActivityLauncherImpl(
        registry,
        ActivityResultContracts.RequestPermission()
    )

    /**
     * Wrapper for [ActivityResultContracts.TakePicturePreview]
     */
    @Suppress("unused")
    fun takePicturePreview(
        registry: ActivityResultRegistry,
    ): ActivityLauncher<Void, Bitmap?> = ActivityLauncherImpl(
        registry,
        ActivityResultContracts.TakePicturePreview()
    )

    /**
     * Wrapper for [ActivityResultContracts.TakePicture]
     */
    @Suppress("unused")
    fun takePicture(
        registry: ActivityResultRegistry,
    ): ActivityLauncher<Uri, Boolean> = ActivityLauncherImpl(
        registry,
        ActivityResultContracts.TakePicture()
    )

    /**
     * Wrapper for [ActivityResultContracts.TakeVideo]
     */
    @Suppress("unused")
    fun takeVideoLauncher(
        registry: ActivityResultRegistry,
    ): ActivityLauncher<Uri, Bitmap?> = ActivityLauncherImpl(
        registry,
        ActivityResultContracts.TakeVideo()
    )

    /**
     * Wrapper for [ActivityResultContracts.PickContact]
     */
    @Suppress("unused")
    fun pickContact(registry: ActivityResultRegistry): ActivityLauncher<Void, Uri?> =
        ActivityLauncherImpl(
            registry,
            ActivityResultContracts.PickContact()
        )

    /**
     * Wrapper for [ActivityResultContracts.GetContent]
     */
    @Suppress("unused")
    fun getContents(registry: ActivityResultRegistry): ActivityLauncher<String, Uri?> =
        ActivityLauncherImpl(
            registry,
            ActivityResultContracts.GetContent()
        )

    /**
     * Wrapper for [ActivityResultContracts.GetMultipleContents]
     */
    @Suppress("unused")
    fun getMultipleContents(registry: ActivityResultRegistry): ActivityLauncher<String, List<Uri>> =
        ActivityLauncherImpl(
            registry,
            ActivityResultContracts.GetMultipleContents()
        )

    /**
     * Wrapper for [ActivityResultContracts.OpenDocument]
     */
    @Suppress("unused")
    fun openDocument(registry: ActivityResultRegistry): ActivityLauncher<Array<String>, Uri?> =
        ActivityLauncherImpl(
            registry,
            ActivityResultContracts.OpenDocument()
        )

    /**
     * Wrapper for [ActivityResultContracts.OpenMultipleDocuments]
     */
    @Suppress("unused")
    fun openMultipleDocuments(registry: ActivityResultRegistry): ActivityLauncher<Array<String>, List<Uri>> =
        ActivityLauncherImpl(
            registry,
            ActivityResultContracts.OpenMultipleDocuments()
        )

    /**
     * Wrapper for [ActivityResultContracts.OpenDocumentTree]
     */
    @Suppress("unused")
    fun openDocumentTree(registry: ActivityResultRegistry): ActivityLauncher<Uri?, Uri?> =
        ActivityLauncherImpl(
            registry,
            ActivityResultContracts.OpenDocumentTree()
        )

    /**
     * Wrapper for [ActivityResultContracts.CreateDocument]
     */
    @Suppress("unused")
    fun createDocument(registry: ActivityResultRegistry): ActivityLauncher<String, Uri?> =
        ActivityLauncherImpl(
            registry,
            ActivityResultContracts.CreateDocument()
        )
}
