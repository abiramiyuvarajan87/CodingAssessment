package com.abiramikrishnamoorthy.coding.assessment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.abiramikrishnamoorthy.coding.assessment.databinding.ActivityGithubCommitListBinding;
import com.abiramikrishnamoorthy.coding.assessment.viewmodel.GitHubCommitListViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class GitHubCommitListActivity extends AppCompatActivity {

    @Inject
    GitHubCommitListViewModel gitHubCommitListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityGithubCommitListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_github_commit_list);
        binding.setViewModel(gitHubCommitListViewModel);
        getLifecycle().addObserver(gitHubCommitListViewModel);
    }
}
