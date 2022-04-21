package com.madroid.launcher.app;

import android.annotation.SuppressLint;

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
    }
}
