package com.abiramikrishnamoorthy.coding.assessment.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abiramikrishnamoorthy.coding.assessment.R;
import com.abiramikrishnamoorthy.coding.assessment.databinding.ItemGithubCommitBinding;
import com.abiramikrishnamoorthy.coding.assessment.viewholder.GitHubCommitListItemViewHolder;
import com.abiramikrishnamoorthy.coding.assessment.viewmodel.GitHubCommitListItemViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GitHubCommitListAdapter extends RecyclerView.Adapter<GitHubCommitListItemViewHolder> {

    private List<GitHubCommitListItemViewModel> gitHubCommitListItems = new ArrayList<>();

    @Inject
    public GitHubCommitListAdapter() { }

    @Override
    public GitHubCommitListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemGithubCommitBinding itemGithubCommitBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_github_commit,parent,false);
        return new GitHubCommitListItemViewHolder(itemGithubCommitBinding);
    }

    @Override
    public void onBindViewHolder(GitHubCommitListItemViewHolder holder, int position) {
        GitHubCommitListItemViewModel gitHubCommitListItemViewModel = gitHubCommitListItems.get(position);
        holder.bind(gitHubCommitListItemViewModel);
    }

    @Override
    public int getItemCount() {
        return (gitHubCommitListItems != null ? gitHubCommitListItems.size() : 0);
    }

    public void setGitHubCommitListItemViewModelList(List<GitHubCommitListItemViewModel> gitHubCommitListItemViewModelList) {
        gitHubCommitListItems = gitHubCommitListItemViewModelList;
        notifyDataSetChanged();
    }
}
