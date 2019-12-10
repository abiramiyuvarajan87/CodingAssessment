package com.abiramikrishnamoorthy.coding.assessment.viewmodel;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;

import com.abiramikrishnamoorthy.coding.assessment.adapter.GitHubCommitListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GitHubCommitListViewModel extends ViewModel implements LifecycleObserver {

    public final GitHubCommitListAdapter adapter = new GitHubCommitListAdapter();

    protected List<GitHubCommitListItemViewModel> gitCommitListResponsesList = new ArrayList<>();

    @Inject
    public GitHubCommitListViewModel() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void populateRecyclerView() {
        gitCommitListResponsesList.clear();
        gitCommitListResponsesList.add(new GitHubCommitListItemViewModel("Author",
                "Commit Hash",
                "Commit Message"));
        adapter.setGitHubCommitListItemViewModelList(gitCommitListResponsesList);
    }
}
