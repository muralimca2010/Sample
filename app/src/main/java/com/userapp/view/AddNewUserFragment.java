package com.userapp.view;

import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.userapp.R;
import com.userapp.viewmodel.NewUserViewModel;


public class AddNewUserFragment extends Fragment {

    private NewUserViewModel newUserViewModel;

    public static AddNewUserFragment newInstance() {
        return new AddNewUserFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        newUserViewModel = ViewModelProviders.of(this).get(NewUserViewModel.class);

        AppCompatButton login_btn  = view.findViewById(R.id.login_btn);
        AppCompatButton fb_btn  = view.findViewById(R.id.fb_btn);
        TextInputEditText fname = view.findViewById(R.id.fname);
        TextInputEditText job = view.findViewById(R.id.job);
        TextInputEditText mailid = view.findViewById(R.id.emailid);
        TextInputEditText password = view.findViewById(R.id.password);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fName = fname.getText().toString().trim();
                String job_ = job.getText().toString().trim();
                String eMail = mailid.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(fName.length()==0 ||eMail.length()==0 ||pass.length()==0 ) {
                    Toast.makeText(getActivity(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
//                    Toast.makeText(getActivity(), "Thank you for Register!", Toast.LENGTH_SHORT).show();
                    newUserViewModel.sendInsertRequest(fName, job_);
                    getActivity().finish();
                }
            }
        });

        fb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOpenFacebookIntent(getActivity());
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    public static Intent getOpenFacebookIntent(Context context) {

        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/<id_here>"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/<user_name_here>"));
        }
    }

}