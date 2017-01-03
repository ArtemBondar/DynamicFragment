package com.github.artembondar.dynamicfragment.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.artembondar.dynamicfragment.R;


public class FirstFragment extends Fragment {


    public static final String TAG = "FirstFragmentTag";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.v(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment1, null);
    }
}