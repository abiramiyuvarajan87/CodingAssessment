package com.abiramikrishnamoorthy.coding.assessment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import dagger.android.AndroidInjection;

public class GitHubCommitListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
