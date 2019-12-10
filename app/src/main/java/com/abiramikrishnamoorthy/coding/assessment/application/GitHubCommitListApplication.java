package com.abiramikrishnamoorthy.coding.assessment.application;

import android.app.Activity;
import android.app.Application;

import com.abiramikrishnamoorthy.coding.assessment.dependencyinjection.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class GitHubCommitListApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder()
                .build()
                .inject(this);
    }
}
