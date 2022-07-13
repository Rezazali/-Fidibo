package com.book.fidibo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;


import android.os.Bundle;

import android.view.MenuItem;
import android.view.WindowManager;

import com.book.fidibo.adapter.TabsAdapter;
import com.book.fidibo.databinding.ActivityMainBinding;
import com.book.fidibo.fragment.HomeFragment;
import com.book.fidibo.fragment.LibraryFragment;
import com.book.fidibo.fragment.SearchFragment;
import com.book.fidibo.fragment.SpecialFragment;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Secure for Create ScreenShot
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);

        binding = ActivityMainBinding.inflate(getLayoutInflater());



        setContentView(binding.getRoot());

        SetClickMenu();

        List<Fragment>fragmentList = new ArrayList<>();
        fragmentList.add(new LibraryFragment());
        fragmentList.add(new SearchFragment());
        fragmentList.add(new SpecialFragment());
        fragmentList.add(new HomeFragment());

        TabsAdapter adapter = new TabsAdapter(this,fragmentList);
        binding.viewPager.setAdapter(adapter);


    }

    public void SetClickMenu(){
        binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


              /*       switch (item.getItemId()){}
               *        if use switch in this case will be warning
               *        warning Resource IDs will be non-final by default in Android Gradle Plugin version 8.0,
               *        avoid using them in switch case statements
               */

                    if(item.getItemId() == R.id.bottom_library){
                        binding.viewPager.setCurrentItem(0);
                        binding.bottomNav.getMenu().findItem(R.id.bottom_library).setChecked(true);
                        }

                    if(item.getItemId() == R.id.bottom_search) {
                       binding.viewPager.setCurrentItem(1);
                       binding.bottomNav.getMenu().findItem(R.id.bottom_search).setChecked(true);
                    }

                   if(item.getItemId() == R.id.bottom_special) {
                       binding.viewPager.setCurrentItem(2);
                       binding.bottomNav.getMenu().findItem(R.id.bottom_special).setChecked(true);
                   }

                   if(item.getItemId() == R.id.bottom_home) {
                       binding.viewPager.setCurrentItem(3);
                       binding.bottomNav.getMenu().findItem(R.id.bottom_home).setChecked(true);
                   }

                return false;
            }
        });

    }

}