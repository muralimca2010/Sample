package com.userapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.userapp.view.ui.main.AddNewUserFragment;

public class AddNewUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_user_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AddNewUserFragment.newInstance())
                    .commitNow();
        }
    }
}