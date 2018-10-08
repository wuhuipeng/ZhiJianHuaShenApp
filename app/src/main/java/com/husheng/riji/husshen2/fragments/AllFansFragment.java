package com.husheng.riji.husshen2.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;



import com.husheng.riji.husshen2.R;

public class AllFansFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return LayoutInflater.from(getActivity()).inflate(R.layout.fragment_all_fans, container, false);
}
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
