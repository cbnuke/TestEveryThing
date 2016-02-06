package com.cbnuke.testeverything;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cbnuke.testeverything.databinding.SlideMainBinding;

/**
 * Created by Amnart on 5/2/2559.
 */
public class SlideActivity extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.slide_main, container, false);

        SlideMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.slide_main, container, false);
        Picture pic = new Picture("Test", "User");
        binding.setPicture(pic);
        View v = binding.getRoot();

        return v;
    }
}
