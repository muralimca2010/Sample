package com.userapp.view;

import android.annotation.SuppressLint;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.userapp.R;
import com.userapp.databinding.ActivityUserBinding;
import com.userapp.model.User;
import java.util.Objects;


public class UserActivity extends AppCompatActivity {

  private User user;
  private ActivityUserBinding userActivityBinding;

  @SuppressLint("ResourceAsColor")
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    userActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle("");
    setSupportActionBar(toolbar);

    Intent intent = getIntent();

    if (intent.hasExtra("user")) {
      user = getIntent().getParcelableExtra("user");
      userActivityBinding.setUserDetail(user);
    }

    LinearLayoutCompat account_type = findViewById(R.id.etv_account_type);
    EditText account_url = findViewById(R.id.et_account_type);
    TextInputLayout eti_account_type = findViewById(R.id.eti_account_type);
    EditText et_name = findViewById(R.id.et_name);
    EditText et_email = findViewById(R.id.et_email);
    EditText et_username = findViewById(R.id.et_username);
    EditText et_mob = findViewById(R.id.et_mob);
    EditText et_address = findViewById(R.id.et_address);
    EditText et_account_type = findViewById(R.id.et_account_type);
    EditText et_member = findViewById(R.id.et_member);
    TextView edit_btn  = findViewById(R.id.edit_btn);

    edit_btn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if((edit_btn.getText().toString().trim().equals("Edit"))) {
          edit_btn.setText("    Update    ");
          et_name.setEnabled(true);
          et_email.setEnabled(true);
          et_username.setEnabled(true);
          et_mob.setEnabled(true);
          et_address.setEnabled(true);
          et_account_type.setEnabled(true);
          et_member.setEnabled(true);
        } else {

          edit_btn.setText("    Edit    ");
          et_name.setEnabled(false);
          et_email.setEnabled(false);
          et_username.setEnabled(false);
          et_mob.setEnabled(false);
          et_address.setEnabled(false);
          et_account_type.setEnabled(false);
          et_member.setEnabled(false);

        }
      }
    });

    account_type.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String url_ = account_url.getText().toString();
        Intent i = new Intent(UserActivity.this, WebViewActivity.class);
        i.putExtra("isUrl", url_);
        startActivity(i);
      }
    });

    eti_account_type.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String url_ = account_url.getText().toString();
        Intent i = new Intent(UserActivity.this, WebViewActivity.class);
        i.putExtra("isUrl", url_);
        startActivity(i);
      }
    });

    account_url.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String url_ = account_url.getText().toString();
        Intent i = new Intent(UserActivity.this, WebViewActivity.class);
        i.putExtra("isUrl", url_);
        startActivity(i);
      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    MenuInflater menuInflater = getMenuInflater();
    menuInflater.inflate(R.menu.detail_menu, menu);


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

    for(int i = 0; i < menu.size(); i++) {
      MenuItem item = menu.getItem(i);
      SpannableString spanString = new SpannableString(menu.getItem(i).getTitle().toString());
      spanString.setSpan(new ForegroundColorSpan(Color.WHITE), 0,     spanString.length(), 0); //fix the color to white
      item.setTitle(spanString);
    }

    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    switch(item.getItemId()){

      case R.id.bck_btn:
//        Toast.makeText(this, "You clicked Back Button", Toast.LENGTH_SHORT).show();
        this.finish();
        break;

      case R.id.addUser:
        Toast.makeText(this, "You clicked Add User", Toast.LENGTH_SHORT).show();
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
}
