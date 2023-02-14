package com.example.catchingup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class signupFragment extends Fragment {
    private EditText etUsername, etPassword;
    private Button btnSignup;
    private FirebaseServices fbs;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public signupFragment() {
        // Required empty public constructor
    }

    public static signupFragment newInstance(String param1, String param2) {
        signupFragment fragment = new signupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        fbs = FirebaseServices.getInstance();
        etUsername = getView().findViewById(R.id.etUsernameSignup);
        etPassword = getView().findViewById(R.id.etPasswordSignup);
        btnSignup = getView().findViewById(R.id.btnSignupSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              String username = etUsername.getText().toString();
              String password = etPassword.getText().toString();
              if(username.trim().isEmpty()&& password.trim().isEmpty()){
                  Toast.makeText(getActivity(), "some fields are empty! ", Toast.LENGTH_SHORT).show();
                  return;

              }
                fbs.getAuth().createUserWithEmailAndPassword(username,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                             gotorecyclerview();

                        }
                        else {
                            Toast.makeText(getActivity(), "check ur data dumb", Toast.LENGTH_SHORT).show();
                        }


                    }
                });



            }
        });
    }

    private void gotorecyclerview() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayoutmain, new fbsrecyclerview());
        ft.commit();
    }
}