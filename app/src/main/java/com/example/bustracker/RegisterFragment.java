package com.example.bustracker;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }
    public static RegisterFragment newInstance() {
        RegisterFragment registerFrag = new RegisterFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, toolbarTitle);
//        registerFrag.setArguments(args);
        return registerFrag;
    }

}
