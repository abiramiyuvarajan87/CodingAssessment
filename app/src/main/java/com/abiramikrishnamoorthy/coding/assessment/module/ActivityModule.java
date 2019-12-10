package com.abiramikrishnamoorthy.coding.assessment.module;


import com.abiramikrishnamoorthy.coding.assessment.GitHubCommitListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract GitHubCommitListActivity bindGitHubCommitListActivity();
}
