package com.danmitch.android.bottomnavigationviewwithfragments;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Built on 4/5/19 by drmitchell85
 * Created using BottomNavigationView with Fragments - Android Studio Tutorial
 * by Coding in Flow
 * https://www.youtube.com/watch?v=tPV8xA7m-iw
 *
 * This demo does not have a view pager to allow the swiping between fragments,
 * bc it is discouraged by material design standards
 */
public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // sets a default fragment value to show upon activity launch
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private void initWidgets() {
        bottomNav = findViewById(R.id.bottom_navigation);
    }

    /**
     * Listener for out BottomNavigationView
     * Created here instead of in 'bottomNav.setOnNavigationItemSelectedListener(___);'
     * -> this is done to keep onCreate() clear of excessive code
     */
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    // these IDs are defined in menu > bottom_navigation.xml
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_contacts:
                            selectedFragment = new ContactsFragment();
                            break;

                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                    }

                    // now we must display the fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

}
