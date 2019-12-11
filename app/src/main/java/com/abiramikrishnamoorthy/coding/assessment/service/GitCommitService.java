package com.abiramikrishnamoorthy.coding.assessment.service;

import com.abiramikrishnamoorthy.coding.assessment.models.GitCommitListResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitCommitService {

    @GET("{repoName}/{projectName}/commits")
    Single<List<GitCommitListResponse>> fetchGitCommitList(@Path("repoName") String gitRepoName, @Path("projectName") String gitProjectName);
}
