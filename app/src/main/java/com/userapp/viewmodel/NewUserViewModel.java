package com.userapp.viewmodel;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.AndroidViewModel;

import com.userapp.model.InsertUser;
import com.userapp.model.InsertUserResp;
import com.userapp.service.RetrofitInstance;
import com.userapp.service.UserDataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewUserViewModel extends AndroidViewModel {



  private Context context;
  public ObservableInt progressBar;

  public NewUserViewModel(@NonNull Application application) {
    super(application);

    this.context = application;
    progressBar = new ObservableInt(View.GONE);


  }


  public void sendInsertRequest(String name , String job)
  {


    progressBar.set(View.VISIBLE);

//    APIService apiService = RetroClass.getAPIService();
    UserDataService apiService = RetrofitInstance.getService();
    InsertUser modal = new InsertUser(name, job);
    Call<InsertUserResp> insertresponse = apiService.createUser(modal);
    insertresponse.enqueue(new Callback<InsertUserResp>() {
      @Override
      public void onResponse(Call<InsertUserResp> call, Response<InsertUserResp> response) {

        progressBar.set(View.GONE);

        showToast(""+response.body().getName().toString()+"  : Successfully createdAt: "+
                response.body().getCreatedAt().toString());


      }

      @Override
      public void onFailure(Call<InsertUserResp> call, Throwable t) {
        progressBar.set(View.GONE);
        showToast(""+t.getMessage());

      }
    });




  }


  void showToast(String msg)
  {

    Toast.makeText(context,msg,Toast.LENGTH_LONG).show();

  }

}
