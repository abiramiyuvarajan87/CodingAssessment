package com.abiramikrishnamoorthy.coding.assessment.provider;

import com.abiramikrishnamoorthy.coding.assessment.models.GitCommitListResponse;
import com.abiramikrishnamoorthy.coding.assessment.service.GitCommitService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GitCommitListProvider {

    private final GitCommitService gitCommitService;

    @Inject
    public GitCommitListProvider(GitCommitService gitCommitService) {
        this.gitCommitService = gitCommitService;
    }

    public Single<List<GitCommitListResponse>> getGitCommitList(String repoName, String projectName) {
        return gitCommitService
                .fetchGitCommitList(repoName, projectName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
