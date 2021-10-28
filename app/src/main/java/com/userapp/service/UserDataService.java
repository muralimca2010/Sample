package com.userapp.service;

import com.userapp.model.InsertUser;
import com.userapp.model.InsertUserResp;
import com.userapp.model.UpdateUserResp;
import com.userapp.model.UserDBResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;


public interface UserDataService {
  @GET("users")
  Call<UserDBResponse> getUsers();

  @GET("users")
  Call<UserDBResponse> getUsersWithPaging(@Query("page") long page);

  @POST("users")
  Call<InsertUserResp> createUser(@Body InsertUser insertUser);

  @PUT("users")
  Call<UpdateUserResp> updateUser(@Body InsertUser insertUser);

}
