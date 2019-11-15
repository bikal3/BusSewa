package com.example.bustracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnlogin, btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btn_main_login);
        btnregister = findViewById(R.id.btn_main_register);
        btnlogin.setOnClickListener(this);
        btnregister.setOnClickListener(this);

        loadFragment(LoginFragment.newInstance());

    }
    private void loadFragment(Fragment activeFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout_main, activeFragment).commit();
    }

    @Override
    public void onClick(View v) {
        Fragment activeFragment = null;
        switch (v.getId()) {
            case R.id.btn_main_login:
                activeFragment = LoginFragment.newInstance();
                break;
            case R.id.btn_main_register:
                activeFragment = RegisterFragment.newInstance();
                break;
        }
        loadFragment(activeFragment);
    }
}
