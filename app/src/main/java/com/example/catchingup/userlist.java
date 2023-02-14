package com.example.catchingup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;

public class userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;

    //TODO: 11:59

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);
    }
}