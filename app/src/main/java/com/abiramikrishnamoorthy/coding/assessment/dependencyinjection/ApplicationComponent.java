package com.abiramikrishnamoorthy.coding.assessment.dependencyinjection;


import com.abiramikrishnamoorthy.coding.assessment.application.GitHubCommitListApplication;
import com.abiramikrishnamoorthy.coding.assessment.module.ActivityModule;
import com.abiramikrishnamoorthy.coding.assessment.module.ApplicationModule;
import com.abiramikrishnamoorthy.coding.assessment.module.ProviderModule;
import com.abiramikrishnamoorthy.coding.assessment.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityModule.class,
        AndroidSupportInjectionModule.class,
        ProviderModule.class,
        ServiceModule.class
})

public interface ApplicationComponent {

    void inject(GitHubCommitListApplication gitHubCommitListApplication);
}
