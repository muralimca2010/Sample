package com.userapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.userapp.model.User;
import com.userapp.model.UserDataSource;
import com.userapp.model.UserDataSourceFactory;
import com.userapp.model.UserRepository;
import com.userapp.service.RetrofitInstance;
import com.userapp.service.UserDataService;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class MainActivityViewModel extends AndroidViewModel {
  private UserRepository userRepository;

  LiveData<UserDataSource> userDataSourceLiveData;
  private Executor executor;
  private LiveData<PagedList<User>> usersPagedList;

  public MainActivityViewModel(@NonNull Application application) {
    super(application);
    userRepository = new UserRepository(application);

    UserDataService userDataService = RetrofitInstance.getService();
    UserDataSourceFactory factory = new UserDataSourceFactory(userDataService);
    userDataSourceLiveData = factory.getMutableLiveData();

    PagedList.Config config = (new PagedList.Config.Builder())
        .setEnablePlaceholders(true)
        .setInitialLoadSizeHint(10)
        .setPageSize(20)
        .setPrefetchDistance(4)
        .build();

    executor = Executors.newFixedThreadPool(5);

    usersPagedList = (new LivePagedListBuilder<Long, User>(factory, config))
        .setFetchExecutor(executor)
        .build();
  }

  public LiveData<List<User>> getAllUsers() {

    return userRepository.getMutableLiveData();
  }

  public LiveData<PagedList<User>> getMoviesPagedList() {
    return usersPagedList;
  }
}
