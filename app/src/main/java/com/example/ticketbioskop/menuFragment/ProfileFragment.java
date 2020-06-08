package com.example.ticketbioskop.menuFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticketbioskop.LoginActivity;
import com.example.ticketbioskop.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private Fragment newFragment;
    FirebaseAuth firebaseAuth;

    public ProfileFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_profile, container, false);
        Button LogoutButton = v.findViewById(R.id.btn_logout);
        TextView displayNama = v.findViewById(R.id.nama);
        Button editProfile = v.findViewById(R.id.btn_edit);
        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Button topUpbutton = v.findViewById(R.id.btn_topup);


        displayNama.setText(user.getEmail());

        topUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topap();
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPass();
            }
        });


        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        return v;
    }


    public void topap(){
        startActivity(new Intent(getActivity(), Topup.class));
        getActivity().finishAffinity();
    }

    public void editPass(){
        startActivity(new Intent(getActivity(), editProfile.class));
        getActivity().finishAffinity();
    }


    public void logout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finishAffinity();
    }
}
