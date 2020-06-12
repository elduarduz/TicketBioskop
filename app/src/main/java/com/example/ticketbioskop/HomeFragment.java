package com.example.ticketbioskop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ticketbioskop.menuFragment.MainFragment;
import com.example.ticketbioskop.menuFragment.Point;
import com.example.ticketbioskop.menuFragment.ProfileFragment;
import com.example.ticketbioskop.menuFragment.Transaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        BottomNavigationView bottomNavigationView = v.findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        switchFragment(new MainFragment());
                        return true;
                    case R.id.menu_calculate_calory:
                        switchFragment(new Point());
                        return true;
                    case R.id.menu_consume_calory:
                        switchFragment(new Transaction());
                        return true;
                    case R.id.menu_list_calory:
                        switchFragment(new ProfileFragment());
                        return true;
                }
                return false;
            }
        });
        switchFragment(new MainFragment());
        return v;
    }
    private void switchFragment(Fragment newFragment) {
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment_container, newFragment);
        fragmentTransaction.commit();
    }
}
