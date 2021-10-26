package com.userapp.view;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.userapp.R;
import com.userapp.adapter.UserAdapter;
import com.userapp.adapter.UserOnClickEvent;
import com.userapp.databinding.ActivityMainBinding;
import com.userapp.model.User;
import com.userapp.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity implements UserOnClickEvent {
  private PagedList<User> users;
  private RecyclerView recyclerView;
  private UserAdapter userAdapter;
  private SwipeRefreshLayout swipeRefreshLayout;
  private MainActivityViewModel mainActivityViewModel;
  private ActivityMainBinding activityMainBinding;
  private UserOnClickEvent clickEvent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);

    mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

    getUsers();

    swipeRefreshLayout = activityMainBinding.swipeLayout;
    swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
    swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        getUsers();
      }
    });
  }

  public void getUsers() {
    mainActivityViewModel.getUsersPagedList().observe(this, new Observer<PagedList<User>>() {
      @Override
      public void onChanged(@Nullable PagedList<User> usersFromLiveData) {
        users = usersFromLiveData;
        showOnRecyclerView();
      }
    });
  }

  private void showOnRecyclerView() {
    recyclerView = activityMainBinding.rvUser;
    userAdapter = new UserAdapter(this,this);
    userAdapter.submitList(users);

    if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
      recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
    } else {

      recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(userAdapter);
    userAdapter.notifyDataSetChanged();
    if (swipeRefreshLayout.isRefreshing()) {
      swipeRefreshLayout.setRefreshing(false);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.menu, menu);

//    //getting the search view from the menu
//    MenuItem searchViewItem = menu.findItem(R.id.menuSearch);
//
//    //getting search manager from systemservice
//    SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//
//    //getting the search view
//    final SearchView searchView = (SearchView) searchViewItem.getActionView();
//
//    //you can put a hint for the search input field
//    searchView.setQueryHint("Search Tutorials...");
//    searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//
//    //by setting it true we are making it iconified
//    //so the search input will show up after taping the search iconified
//    //if you want to make it visible all the time make it false
//    searchView.setIconifiedByDefault(true);
//
//    //here we will get the search query
//    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//      @Override
//      public boolean onQueryTextSubmit(String query) {
//
//        //do the search here
//        return false;
//      }
//
//      @Override
//      public boolean onQueryTextChange(String newText) {
//        return false;
//      }
//    });

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch(item.getItemId()){

      case R.id.bck_btn:
        Toast.makeText(this, "You clicked Back Button", Toast.LENGTH_SHORT).show();
        break;

      case R.id.addUser:
//        Toast.makeText(this, "You clicked Add User", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, AddNewUser.class);
        startActivity(i);
        break;

      case R.id.menuSearch:
        Toast.makeText(this, "You clicked Search", Toast.LENGTH_SHORT).show();
        break;

      case R.id.notify:
        Toast.makeText(this, "You clicked Notification", Toast.LENGTH_SHORT).show();
        break;

      case R.id.menuAbout:
        Toast.makeText(this, "You clicked about", Toast.LENGTH_SHORT).show();
        break;

      case R.id.menuSettings:
        Toast.makeText(this, "You clicked settings", Toast.LENGTH_SHORT).show();
        break;

      case R.id.menuLogout:
        Toast.makeText(this, "You clicked logout", Toast.LENGTH_SHORT).show();
        break;

    }
    return true;
  }

  @Override
  public void onUserClick(User user) {

            Intent intent = new Intent(this, UserActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
//    Bundle args = new Bundle();
//    args.putParcelable("user", user);
//    UserProfileFragment fragment = new UserProfileFragment();
//    fragment.setArguments(args);
//    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//    transaction.replace(R.id.frameLayout, fragment);
//    transaction.commit();

  }
}
