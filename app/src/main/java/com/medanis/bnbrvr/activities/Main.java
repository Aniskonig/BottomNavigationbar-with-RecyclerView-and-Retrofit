package com.medanis.bnbrvr.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.medanis.bnbrvr.MyFragments.FragmentA;
import com.medanis.bnbrvr.MyFragments.FragmentB;
import com.medanis.bnbrvr.R;
import com.medanis.bnbrvr.ui.dashboard.DashboardFragment;

public class Main extends AppCompatActivity implements FragmentA.OnMessageReadListner {


    Context context = Main.this;


    FragmentA fragA ;
    FragmentB fragB;

    DashboardFragment dfragment;

    FrameLayout myframe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        myframe = findViewById(R.id.my_frame);
        fragA = new FragmentA();
        fragB = new FragmentB();
        dfragment = new DashboardFragment();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.my_frame,fragA)
                .commit();





        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Toast.makeText(context, "Recents", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.my_frame, fragA)
                                .commit();
                        break;
                    case R.id.navigation_dashboard:
                        Toast.makeText(context, "Favorites", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.my_frame,fragB)
                                .commit();
                        break;
                    case R.id.navigation_notifications:
                        Toast.makeText(context, "Nearby", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }


    @Override
    public void OnMessageRead(String r) {
        Toast.makeText(context," reading "+r,Toast.LENGTH_SHORT).show();
    }

    }
