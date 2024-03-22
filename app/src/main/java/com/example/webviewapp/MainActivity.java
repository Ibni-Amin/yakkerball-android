package com.example.webviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.webviewapp.Adapter.CategoryAdatpter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    CategoryAdatpter categoryAdatpter;
    ArrayList<CateModal> cateList;
    RecyclerView rvMove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cateList = new ArrayList<>();

        rvMove= findViewById(R.id.rvMove);

        dataInsertion();

        categoryAdatpter = new CategoryAdatpter(MainActivity.this,cateList);
        rvMove.setAdapter(categoryAdatpter);

    }

    private void dataInsertion() {
        cateList.add(new CateModal("Home","https://yakkerball.com/",R.drawable.home));
        cateList.add(new CateModal("Log In","https://yakkerball.com/login",R.drawable.login));
        cateList.add(new CateModal("Sign Up","https://yakkerball.com/register",R.drawable.signup));
        cateList.add(new CateModal("Terms & Conditions","https://yakkerball.com/terms-and-conditions",R.drawable.terms));
        cateList.add(new CateModal("Privacy","https://yakkerball.com/privacy-policy",R.drawable.privay));
        cateList.add(new CateModal("Contact","https://yakkerball.com/",R.drawable.content));
    }
}