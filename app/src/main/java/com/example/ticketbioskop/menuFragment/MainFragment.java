package com.example.ticketbioskop.menuFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ticketbioskop.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        ImageView imageProfile = v.findViewById(R.id.profile_button);
        imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profil();
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
    public void profil(){
        Navigation.findNavController(getView()).navigate(R.id.action_homeFragment2_to_profileFragment);
    }
}
