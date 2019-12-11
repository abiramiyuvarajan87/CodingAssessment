package com.abiramikrishnamoorthy.coding.assessment.module;

import com.abiramikrishnamoorthy.coding.assessment.service.GitCommitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceModule {
    private String BASE_URL = "https://api.github.com/repos/";

    @Provides
    @Singleton
    public Retrofit provicesRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    public GitCommitService providesGitCommitService(Retrofit retrofit) {
        return retrofit.create(GitCommitService.class);
    }
}
