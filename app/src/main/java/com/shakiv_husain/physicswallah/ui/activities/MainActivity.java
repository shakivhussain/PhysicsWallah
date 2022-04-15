package com.shakiv_husain.physicswallah.ui.activities;

import static com.shakiv_husain.physicswallah.utills.contants.AppConstants.HOME_FRAGMENT;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.shakiv_husain.physicswallah.R;
import com.shakiv_husain.physicswallah.databinding.ActivityMainBinding;
import com.shakiv_husain.physicswallah.databinding.HeaderToolbarLayoutBinding;
import com.shakiv_husain.physicswallah.ui.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private HeaderToolbarLayoutBinding headerToolbarLayoutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        initialization();
    }

    private void initialization() {
        setFragment(new HomeFragment(), HOME_FRAGMENT);
        mainBinding.header.backButton.setOnClickListener(view -> onBackPressed());
    }

    private void setFragment(HomeFragment homeFragment, String tag) {
        try {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_layout, homeFragment, tag)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

}