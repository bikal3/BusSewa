package com.example.bustracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnlogin, btnregister;
    private View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btnlogin = findViewById(R.id.btn_main_login);
//        btnregister = findViewById(R.id.btn_main_register);
//        btnlogin.setOnClickListener(this);
//        btnregister.setOnClickListener(this);
//        layout=findViewById(R.id.mainLayout);
//
//        loadFragment(LoginFragment.newInstance());

    }
//    private void loadFragment(Fragment activeFragment) {
//        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_main, activeFragment).commit();
//    }
//
//    @Override
//    public void onClick(View v) {
//        Fragment activeFragment = null;
//        switch (v.getId()) {
//            case R.id.btn_main_login:
//
//                break;
//            case R.id.btn_main_register:
//
//        }
//        loadFragment(activeFragment);
//    }
}
