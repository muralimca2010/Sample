package com.userapp.model;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.userapp.service.RetrofitInstance;
import com.userapp.service.UserDataService;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UserDataSource extends PageKeyedDataSource<Long, User> {
  private UserDataService userDataService;

  public UserDataSource(UserDataService userDataService) {
    this.userDataService = userDataService;
  }

  @Override
  public void loadInitial(@NonNull LoadInitialParams<Long> params,
      @NonNull final LoadInitialCallback<Long, User> callback) {

    userDataService = RetrofitInstance.getService();
    Call<UserDBResponse> call = userDataService.getUsersWithPaging(1);

    call.enqueue(new Callback<UserDBResponse>() {
      @Override
      public void onResponse(Call<UserDBResponse> call, Response<UserDBResponse> response) {

        UserDBResponse userDBResponse = response.body();
        ArrayList<User> users = new ArrayList<>();

        if (userDBResponse != null && userDBResponse.getUsers() != null) {
          users = (ArrayList<User>) userDBResponse.getUsers();

          callback.onResult(users, null, (long) 2);
        }
      }

      @Override
      public void onFailure(Call<UserDBResponse> call, Throwable t) {

      }
    });
  }

  @Override
  public void loadBefore(@NonNull LoadParams<Long> params,
      @NonNull LoadCallback<Long, User> callback) {

  }

  @Override
  public void loadAfter(@NonNull final LoadParams<Long> params,
      @NonNull final LoadCallback<Long, User> callback) {

    userDataService = RetrofitInstance.getService();
    Call<UserDBResponse> call = userDataService.getUsersWithPaging(params.key);
    call.enqueue(new Callback<UserDBResponse>() {
      @Override
      public void onResponse(Call<UserDBResponse> call, Response<UserDBResponse> response) {

        UserDBResponse userDBResponse = response.body();
        ArrayList<User> users = new ArrayList<>();

        if (userDBResponse != null && userDBResponse.getUsers() != null) {
          users = (ArrayList<User>) userDBResponse.getUsers();

          callback.onResult(users, params.key + 1);
        }
      }

      @Override
      public void onFailure(Call<UserDBResponse> call, Throwable t) {

      }
    });
  }
}
