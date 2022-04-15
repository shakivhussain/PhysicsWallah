package com.shakiv_husain.physicswallah.data.api.network;

import static com.shakiv_husain.physicswallah.data.api.constants.ApiConstants.USERS;

import com.shakiv_husain.physicswallah.data.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET(USERS)
    Call<List<User>> getUsers();

}
