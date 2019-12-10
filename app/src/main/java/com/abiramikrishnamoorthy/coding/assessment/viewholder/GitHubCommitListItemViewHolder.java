package com.abiramikrishnamoorthy.coding.assessment.viewholder;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.abiramikrishnamoorthy.coding.assessment.databinding.ItemGithubCommitBinding;
import com.abiramikrishnamoorthy.coding.assessment.viewmodel.GitHubCommitListItemViewModel;

import javax.inject.Inject;

public class GitHubCommitListItemViewHolder extends ViewHolder {

    private ItemGithubCommitBinding binding;

    @Inject
    public GitHubCommitListItemViewHolder(ItemGithubCommitBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(GitHubCommitListItemViewModel gitHubCommitListItemViewModel) {
        binding.setCommitListItemViewModel(gitHubCommitListItemViewModel);
        binding.executePendingBindings();
    }
}
