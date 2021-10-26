package com.userapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.userapp.R;
import com.userapp.databinding.ActivityUserBinding;
import com.userapp.model.User;
import com.userapp.view.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class UserProfileFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private User user;
    private ActivityUserBinding userActivityBinding;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UserProfileFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static UserProfileFragment newInstance(int columnCount) {
        UserProfileFragment fragment = new UserProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent intent = getActivity().getIntent();
       User user = getArguments().getParcelable("user");
//        if (intent.hasExtra("user")) {
//            user = getActivity().getIntent().getParcelableExtra("user");
            userActivityBinding.setUserDetail(user);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);


        LinearLayoutCompat account_type = view.findViewById(R.id.etv_account_type);
        EditText account_url = view.findViewById(R.id.et_account_type);
        TextInputLayout eti_account_type = view.findViewById(R.id.eti_account_type);
        EditText et_name = view.findViewById(R.id.et_name);
        EditText et_email = view.findViewById(R.id.et_email);
        EditText et_username = view.findViewById(R.id.et_username);
        EditText et_mob = view.findViewById(R.id.et_mob);
        EditText et_address = view.findViewById(R.id.et_address);
        EditText et_account_type = view.findViewById(R.id.et_account_type);
        EditText et_member = view.findViewById(R.id.et_member);
        TextView edit_btn  = view.findViewById(R.id.edit_btn);

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
                callWebView(url_);
            }
        });

        eti_account_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_ = account_url.getText().toString();
                callWebView(url_);
            }
        });

        account_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url_ = account_url.getText().toString();
                callWebView(url_);
            }
        });



        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(PlaceholderContent.ITEMS));
        }
        return view;
    }
    private void callWebView(String account_url) {
        Intent i = new Intent(getActivity(), WebViewActivity.class);
        i.putExtra("isUrl", account_url);
        startActivity(i);
    }
}