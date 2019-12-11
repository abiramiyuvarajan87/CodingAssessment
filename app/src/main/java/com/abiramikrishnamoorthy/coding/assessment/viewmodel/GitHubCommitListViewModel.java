package com.abiramikrishnamoorthy.coding.assessment.viewmodel;

import android.util.Log;

import androidx.databinding.ObservableBoolean;
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
    public final ObservableBoolean isError = new ObservableBoolean(false);

    private final GitCommitListProvider gitCommitListProvider;

    protected List<GitHubCommitListItemViewModel> gitCommitListResponsesList = new ArrayList<>();
    protected CompositeDisposable lifecycleSubscriptions = new CompositeDisposable();

    @Inject
    public GitHubCommitListViewModel(GitCommitListProvider gitCommitListProvider) {
        this.gitCommitListProvider = gitCommitListProvider;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void fetchGitCommitList() {
        lifecycleSubscriptions.add(gitCommitListProvider.getGitCommitList("concourse", "pipelines")
                .subscribe(this::populateListAdapter, this::populateError));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        lifecycleSubscriptions.clear();
    }

    private void populateListAdapter(List<GitCommitListResponse> gitCommitListResponses) {
        isError.set(false);
        gitCommitListResponsesList.clear();
        gitCommitListResponses.forEach(gitCommitListResponse -> gitCommitListResponsesList.add(new GitHubCommitListItemViewModel(
                gitCommitListResponse.getCommitAuthor().getAuthorName(),
                gitCommitListResponse.getCommitHash(),
                gitCommitListResponse.getCommit().getGitCommitMessage())));
        adapter.setGitHubCommitListItemViewModelList(gitCommitListResponsesList);
    }

    private void populateError(Throwable throwable) {
        Log.e("Exception", throwable.getMessage());
        throwable.printStackTrace();
        isError.set(true);
        gitCommitListResponsesList.clear();
    }
}
