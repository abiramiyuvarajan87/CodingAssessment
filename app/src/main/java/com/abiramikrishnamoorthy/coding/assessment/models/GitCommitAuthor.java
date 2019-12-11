package com.abiramikrishnamoorthy.coding.assessment.models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class GitCommitAuthor {

    @SerializedName("login")
    String authorName;

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GitCommitAuthor that = (GitCommitAuthor) o;
        return Objects.equals(authorName, that.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName);
    }
}
