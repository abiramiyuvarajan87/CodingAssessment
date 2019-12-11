package com.abiramikrishnamoorthy.coding.assessment.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class GitCommitListResponse {
    @SerializedName("sha")
    String commitHash;

    @SerializedName("commit")
    GitCommitMessage commit;

    @SerializedName("author")
    GitCommitAuthor commitAuthor;

    public String getCommitHash() {
        return commitHash;
    }

    public GitCommitMessage getCommit() {
        return commit;
    }

    public GitCommitAuthor getCommitAuthor() {
        return commitAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitCommitListResponse that = (GitCommitListResponse) o;
        return Objects.equals(commitHash, that.commitHash) &&
                Objects.equals(commit, that.commit) &&
                Objects.equals(commitAuthor, that.commitAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commitHash, commit, commitAuthor);
    }
}
