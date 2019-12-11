package com.abiramikrishnamoorthy.coding.assessment.module;

import com.abiramikrishnamoorthy.coding.assessment.provider.GitCommitListProvider;
import com.abiramikrishnamoorthy.coding.assessment.service.GitCommitService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProviderModule {

    @Provides
    @Singleton
    public GitCommitListProvider providesGitCommitListProvider(GitCommitService gitCommitService) {
        return new GitCommitListProvider(gitCommitService);
    }
}
