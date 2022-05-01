package com.madroid.launcher.app;

import android.annotation.SuppressLint;
import android.net.Uri;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContracts;

import com.madroid.activity.launcher.ActivityLauncher;

@SuppressLint("unused")
public class ActivityLauncherJavaSample {

    @SuppressLint("unused")
    void createDocument(ActivityResultRegistry registry) {
        String title = "Title For Create Document";
        ActivityLauncher.startWithContract(registry, new ActivityResultContracts.CreateDocument()).launch(title, null, result -> {
            // handle result
        });

        ActivityLauncher.createDocument(registry).launch(title, result -> {
            // handle result
        });
    }

    @SuppressLint("unused")
    void getContents(ActivityResultRegistry registry) {
        String type = "image/*";
        ActivityLauncher.getContents(registry).launch(type, new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {

            }
        });
        // 也可以使用 lambda 简化写法
        ActivityLauncher.getContents(registry).launch(type, result -> {
            // handle result
        });
    }
}
