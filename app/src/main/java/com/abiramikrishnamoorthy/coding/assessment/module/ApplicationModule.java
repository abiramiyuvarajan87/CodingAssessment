package com.abiramikrishnamoorthy.coding.assessment.module;

import android.app.Application;
import android.content.Context;

import com.abiramikrishnamoorthy.coding.assessment.qualifier.ForApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ForApplication
    Context provideContext() {
        return application;
    }

    @Provides
    Application providesApplication() {
        return application;
    }
}
