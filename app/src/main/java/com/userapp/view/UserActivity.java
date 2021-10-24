package com.userapp.view;

import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.userapp.R;
import com.userapp.databinding.ActivityUserBinding;
import com.userapp.model.User;
import java.util.Objects;


public class UserActivity extends AppCompatActivity {

  private User user;
  private ActivityUserBinding userActivityBinding;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user);
//    Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    userActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_user);

    Intent intent = getIntent();

    if (intent.hasExtra("user")) {
      user = getIntent().getParcelableExtra("user");
      userActivityBinding.setUserDetail(user);
    }

    LinearLayoutCompat account_type = findViewById(R.id.etv_account_type);
    EditText account_url = findViewById(R.id.et_account_type);
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
}
