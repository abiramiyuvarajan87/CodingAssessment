package com.abiramikrishnamoorthy.coding.assessment.viewmodel;

import com.abiramikrishnamoorthy.coding.assessment.models.GitCommitAuthor;
import com.abiramikrishnamoorthy.coding.assessment.models.GitCommitListResponse;
import com.abiramikrishnamoorthy.coding.assessment.models.GitCommitMessage;
import com.abiramikrishnamoorthy.coding.assessment.provider.GitCommitListProvider;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GitHubCommitListViewModelTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private GitCommitListProvider gitCommitListProvider;

    private GitHubCommitListViewModel subject;

    @Before
    public void setup() {
        subject = new GitHubCommitListViewModel(gitCommitListProvider);
    }

    @Test
    public void populateRecyclerView_gitCommitListReturnsList_setsGitHubCommitListItemViewModelList() {
        List<GitCommitListResponse> gitCommitListResponse = populateCommitListResponse();
        when(gitCommitListProvider.getGitCommitList("concourse", "pipelines")).thenReturn(Single.just(gitCommitListResponse));

        subject.populateRecyclerView();

        assertEquals(subject.gitCommitListResponsesList.size(),1);
    }

    @Test
    public void onPause_verifiesLifeCycleSubscriptionsAreCleared() {
        CompositeDisposable lifecycleSubscriptionsTest = mock(CompositeDisposable.class);
        subject.lifecycleSubscriptions.add(lifecycleSubscriptionsTest);

        assertEquals(subject.lifecycleSubscriptions.size(),1);

        subject.onPause();

        assertEquals(subject.lifecycleSubscriptions.size(),0);
    }

    private List<GitCommitListResponse> populateCommitListResponse() {
        GitCommitListResponse gitCommitListResponse = mock(GitCommitListResponse.class);
        GitCommitAuthor gitCommitAuthor = mock(GitCommitAuthor.class);
        GitCommitMessage gitCommitMessage = mock(GitCommitMessage.class);

        when(gitCommitListResponse.getCommitHash()).thenReturn("gitCommitHash");
        when(gitCommitListResponse.getCommit()).thenReturn(gitCommitMessage);
        when(gitCommitMessage.getGitCommitMessage()).thenReturn("gitCommitMessage");
        when(gitCommitListResponse.getCommitAuthor()).thenReturn(gitCommitAuthor);
        when(gitCommitAuthor.getAuthorName()).thenReturn("gitAuthor");

        List<GitCommitListResponse> gitCommitListResponseList = new ArrayList<>();
        gitCommitListResponseList.add(gitCommitListResponse);
        return gitCommitListResponseList;
    }

}