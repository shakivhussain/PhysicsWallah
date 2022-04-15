package com.shakiv_husain.physicswallah.data.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shakiv_husain.physicswallah.data.models.User;
import com.shakiv_husain.physicswallah.data.api.network.ApiClient;
import com.shakiv_husain.physicswallah.data.api.network.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static final String TAG = UserRepository.class.getName();
    private ApiServices apiServices;

    public UserRepository() {
        apiServices = ApiClient.getRetrofit().create(ApiServices.class);
    }

    public LiveData<List<User>> getUsers() {

        MutableLiveData<List<User>> users = new MutableLiveData<>();

        apiServices.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    users.postValue(response.body());
                } else {
                    users.postValue(null);
                }
                Log.e(TAG, "onResponse: " + call.request().url());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                users.postValue(null);
                Log.e(TAG, "onFailure: " + t.getMessage() + " " + call.request().url());
            }
        });

        return users;
    }
}
