package com.userapp.model;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.userapp.service.UserDataService;


public class UserDataSourceFactory extends DataSource.Factory {

  private UserDataSource userDataSource;
  private UserDataService userDataService;
  private MutableLiveData<UserDataSource> mutableLiveData;

  public UserDataSourceFactory(UserDataService userDataService) {
    this.userDataService = userDataService;
    mutableLiveData = new MutableLiveData<>();
  }

  @Override
  public DataSource create() {

    userDataSource = new UserDataSource(userDataService);
    mutableLiveData.postValue(userDataSource);
    return userDataSource;
  }

  public MutableLiveData<UserDataSource> getMutableLiveData() {
    return mutableLiveData;
  }
}

