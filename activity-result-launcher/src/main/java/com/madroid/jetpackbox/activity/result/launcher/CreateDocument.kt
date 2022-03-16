package com.madroid.jetpackbox.activity.result.launcher

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.jetpackbox.activity.result.ActivityLauncher
import com.madroid.jetpackbox.activity.result.ActivityLauncherImpl

/**
 * Wrapper for [ActivityResultContracts.CreateDocument]
 */
@Suppress("unused")
fun ActivityResultLauncher.createDocument(registry: ActivityResultRegistry): ActivityLauncher<String, Uri?> =
    ActivityLauncherImpl(
        registry,
        ActivityResultContracts.CreateDocument()
    )

/**
 * extension for launch [ActivityResultContracts.CreateDocument]
 *
 * @param title  [android.content.Intent.EXTRA_TITLE]
 */
@Suppress("unused")
fun androidx.activity.ComponentActivity.launchCreateDocument(
    title: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityResultLauncher.createDocument(activityResultRegistry).launch(title, options, result)
}

/**
 * extension for launch [ActivityResultContracts.CreateDocument]
 *
 * @param title  [android.content.Intent.EXTRA_TITLE]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.launchCreateDocument(
    title: String,
    options: ActivityOptionsCompat? = null,
): Uri? = ActivityResultLauncher.createDocument(activityResultRegistry).launch(title, options)

/**
 * extension for launch [ActivityResultContracts.CreateDocument]
 *
 * @param title  [android.content.Intent.EXTRA_TITLE]
 */
@Suppress("unused")
fun Fragment.launchCreateDocument(
    title: String,
    options: ActivityOptionsCompat? = null,
    result: ActivityResultCallback<Uri?>
) {
    ActivityResultLauncher.createDocument(requireActivity().activityResultRegistry)
        .launch(title, options, result)
}

/**
 * extension for launch [ActivityResultContracts.CreateDocument]
 *
 * @param title  [android.content.Intent.EXTRA_TITLE]
 */
@Suppress("unused")
suspend fun Fragment.launchCreateDocument(
    title: String,
    options: ActivityOptionsCompat? = null,
): Uri? = ActivityResultLauncher.createDocument(requireActivity().activityResultRegistry)
    .launch(title, options)
