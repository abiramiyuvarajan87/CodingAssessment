package com.abiramikrishnamoorthy.coding.assessment.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.abiramikrishnamoorthy.coding.assessment.adapter.GitHubCommitListAdapter;
import com.abiramikrishnamoorthy.coding.assessment.models.GitCommitListResponse;
import com.abiramikrishnamoorthy.coding.assessment.provider.GitCommitListProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class GitHubCommitListViewModel extends ViewModel implements LifecycleObserver {

    public final GitHubCommitListAdapter adapter = new GitHubCommitListAdapter();

    private final GitCommitListProvider gitCommitListProvider;

    protected List<GitHubCommitListItemViewModel> gitCommitListResponsesList = new ArrayList<>();
    protected CompositeDisposable lifecycleSubscriptions = new CompositeDisposable();

    @Inject
    public GitHubCommitListViewModel(GitCommitListProvider gitCommitListProvider) {
        this.gitCommitListProvider = gitCommitListProvider;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void populateRecyclerView() {
        lifecycleSubscriptions.add(gitCommitListProvider.getGitCommitList("concourse", "pipelines")
                .subscribe(this::populateListAdapter, Throwable::printStackTrace));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        lifecycleSubscriptions.clear();
    }

    private void populateListAdapter(List<GitCommitListResponse> gitCommitListResponses) {
        gitCommitListResponsesList.clear();
        gitCommitListResponses.forEach(gitCommitListResponse -> gitCommitListResponsesList.add(new GitHubCommitListItemViewModel(
                gitCommitListResponse.getCommitAuthor().getAuthorName(),
                gitCommitListResponse.getCommitHash(),
                gitCommitListResponse.getCommit().getGitCommitMessage())));
        adapter.setGitHubCommitListItemViewModelList(gitCommitListResponsesList);
    }
}
