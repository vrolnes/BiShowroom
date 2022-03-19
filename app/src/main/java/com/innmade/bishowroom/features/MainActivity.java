package com.innmade.bishowroom.features;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.innmade.bishowroom.R;
import com.innmade.bishowroom.features.brands.BrandsFragment;
import com.innmade.bishowroom.features.categories.CategoriesFragment;
import com.innmade.bishowroom.features.homepage.HomeFragment;
import com.innmade.bishowroom.features.search.SearchFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    CategoriesFragment categoriesFragment = new CategoriesFragment();
    BrandsFragment brandsFragment = new BrandsFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, homeFragment).commit();
                return true;

            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, searchFragment).commit();
                return true;

            case R.id.categories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, categoriesFragment).commit();
                return true;

            case R.id.brands:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, brandsFragment).commit();
                return true;
        }
        return false;
    }
}