package com.shakiv_husain.physicswallah.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.shakiv_husain.physicswallah.ui.adapters.UserAdapter;
import com.shakiv_husain.physicswallah.databinding.FragmentHomeBinding;
import com.shakiv_husain.physicswallah.ui.viewmodel.AppViewModel;

public class HomeFragment extends Fragment {

    private AppViewModel appViewModel;

    private FragmentHomeBinding homeBinding;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        homeBinding = FragmentHomeBinding.inflate(inflater);

        init();

        return homeBinding.getRoot();
    }

    private void init() {

        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);

        setData();

    }

    private void setData() {

        homeBinding.progressBar.setVisibility(View.VISIBLE);
        appViewModel.getUsers().observe(getViewLifecycleOwner(), userResponse -> {
            if (userResponse != null) {
                homeBinding.progressBar.setVisibility(View.GONE);
                UserAdapter userAdapter = new UserAdapter(userResponse);
                homeBinding.usersRecyclerView.smoothScrollToPosition(1);
                homeBinding.usersRecyclerView.setAdapter(userAdapter);
            }
        });
    }
}