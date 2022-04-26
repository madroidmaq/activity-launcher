package com.madroid.activity.launcher.ext

import android.net.Uri
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.madroid.activity.launcher.ActivityLauncher
import com.madroid.activity.launcher.actions.createDocument

/**
 * extension for launch [ActivityResultContracts.CreateDocument]
 *
 * @param title  [android.content.Intent.EXTRA_TITLE]
 */
@Suppress("unused")
suspend fun androidx.activity.ComponentActivity.awaitCreateDocument(
    title: String,
    options: ActivityOptionsCompat? = null,
): Uri? = ActivityLauncher.createDocument(activityResultRegistry).awaitLaunch(title, options)

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
    ActivityLauncher.createDocument(requireActivity().activityResultRegistry)
        .launch(title, options, result)
}

/**
 * extension for launch [ActivityResultContracts.CreateDocument]
 *
 * @param title  [android.content.Intent.EXTRA_TITLE]
 */
@Suppress("unused")
suspend fun Fragment.awaitCreateDocument(
    title: String,
    options: ActivityOptionsCompat? = null,
): Uri? = ActivityLauncher.createDocument(requireActivity().activityResultRegistry)
    .awaitLaunch(title, options)
