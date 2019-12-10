package com.abiramikrishnamoorthy.coding.assessment.viewmodel;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class GitHubCommitListItemViewModel extends ViewModel {

    private String gitAuthor;
    private String gitCommitHash;
    private String gitCommitMessage;

    @Inject
    public GitHubCommitListItemViewModel(String gitAuthor,
                                         String gitCommitHash,
                                         String gitCommitMessage) {
        this.gitAuthor = gitAuthor;
        this.gitCommitHash = gitCommitHash;
        this.gitCommitMessage = gitCommitMessage;
    }

    public String getGitAuthor() {
        return gitAuthor;
    }

    public String getGitCommitHash() {
        return gitCommitHash;
    }

    public String getGitCommitMessage() {
        return gitCommitMessage;
    }
}
