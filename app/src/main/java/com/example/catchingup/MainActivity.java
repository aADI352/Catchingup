package com.example.catchingup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.ResultReceiver;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private RecyclerView mAdapter;
    private RecyclerView layoutmanager;
    private String[] myDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoLoginFragment();


    }

    private void gotoLoginFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayoutmain, new LoginFragment());
        ft.commit();
    }


}