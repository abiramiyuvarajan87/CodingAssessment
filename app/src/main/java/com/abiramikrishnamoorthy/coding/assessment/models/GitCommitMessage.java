package com.abiramikrishnamoorthy.coding.assessment.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class GitCommitMessage {

    @SerializedName("message")
    String gitCommitMessage;

    public String getGitCommitMessage() {
        return gitCommitMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitCommitMessage that = (GitCommitMessage) o;
        return Objects.equals(gitCommitMessage, that.gitCommitMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gitCommitMessage);
    }
}
