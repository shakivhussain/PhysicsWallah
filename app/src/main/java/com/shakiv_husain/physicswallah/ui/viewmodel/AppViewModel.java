package com.shakiv_husain.physicswallah.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.shakiv_husain.physicswallah.data.models.User;
import com.shakiv_husain.physicswallah.data.repositories.UserRepository;

import java.util.List;

public class AppViewModel extends ViewModel {

    private final UserRepository userRepository;

    public AppViewModel() {
        userRepository = new UserRepository();
    }

    public LiveData<List<User>> getUsers() {
        return userRepository.getUsers();
    }

}
