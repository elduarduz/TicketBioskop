package com.example.ticketbioskop;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.ticketbioskop.R;

public class HomeFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    public void profil(View view){

    }
}