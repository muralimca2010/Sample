package com.userapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.userapp.R;
import com.userapp.viewmodel.NewUserViewModel;

public class AddNewUser extends AppCompatActivity {

    private NewUserViewModel newUserViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_user_activity);

//        newUserViewModel = ViewModelProviders.of(this).get(NewUserViewModel.class);
//
//        AppCompatButton login_btn  = findViewById(R.id.login_btn);
//        AppCompatButton fb_btn  = findViewById(R.id.fb_btn);
//        TextInputEditText fname = findViewById(R.id.fname);
//        TextInputEditText job = findViewById(R.id.job);
//        TextInputEditText mailid = findViewById(R.id.emailid);
//        TextInputEditText password = findViewById(R.id.password);
//
//        login_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String fName = fname.getText().toString().trim();
//                String job_ = job.getText().toString().trim();
//                String eMail = mailid.getText().toString().trim();
//                String pass = password.getText().toString().trim();
//                if(fName.length()==0 ||eMail.length()==0 ||pass.length()==0 ) {
//                    Toast.makeText(AddNewUser.this, "Please fill all details", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(AddNewUser.this, "Thank you for Register!", Toast.LENGTH_SHORT).show();
//                    newUserViewModel.sendInsertRequest(fName, job_);
//                    finish();
//                }
//            }
//        });
//
//        fb_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getOpenFacebookIntent(AddNewUser.this);
//            }
//        });
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AddNewUserFragment.newInstance())
                    .commitNow();
        }


    }




//    public static Intent getOpenFacebookIntent(Context context) {
//
//        try {
//            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
//            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/<id_here>"));
//        } catch (Exception e) {
//            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/<user_name_here>"));
//        }
//    }

}