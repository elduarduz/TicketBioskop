package com.example.ticketbioskop;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_view);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_poin, R.id.navigation_pembayaran)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(bottomNav, navController);
    }

//    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                    Fragment selectedFragment = null;
//                    switch (menuItem.getItemId()){
//                        case R.id.navigation_home:
//                            selectedFragment = new HomeFragment();
//                            break;
//                        case R.id.navigation_poin:
//                            break;
//                        case R.id.navigation_pembayaran:
//                            break;
//                    }
//                    getFragmentManager().beginTransaction().replace(R.id.bottom_nav_view, selectedFragment).commit();
//                    return true;
//                }
//            };
}
