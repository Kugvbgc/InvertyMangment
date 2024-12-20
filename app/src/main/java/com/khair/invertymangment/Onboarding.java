package com.khair.invertymangment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.khair.invertymangment.onboarding.BlankFragment;
import com.khair.invertymangment.onboarding.OnboardingAdapter;
import com.khair.invertymangment.onboarding.OnboardingModel;

import java.util.Arrays;
import java.util.List;

public class Onboarding extends AppCompatActivity {
  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        lodeOnBoding();








    }///onCreate end here*****************************************

    public void lodeOnBoding(){

        List<OnboardingModel> tab= Arrays.asList(
                new OnboardingModel("Home", BlankFragment.class),
                new OnboardingModel("About", BlankFragment.class)

        );
        TabLayout tabLayout=findViewById(R.id.TabLayout);
        ViewPager2 viewPager2=findViewById(R.id.ViewPager2);



        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        OnboardingAdapter onboardingAdapter = new OnboardingAdapter(this,tab);
        viewPager2.setAdapter(onboardingAdapter);
        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            if (viewPager2.getCurrentItem() < onboardingAdapter.getItemCount() - 1) {
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            } else {
                // Finish onboarding
                startActivity(new Intent(Onboarding.this, HomeActivity.class));
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("Onboarding", MODE_PRIVATE);
        boolean hasCompletedOnboarding = sharedPreferences.getBoolean("Completed", false);

        if (hasCompletedOnboarding) {
            // Skip onboarding
            startActivity(new Intent(Onboarding.this, HomeActivity.class));
            finish();
        } else {
            // Show onboarding
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("Completed", true);
            editor.apply();
        }
    }


}///public class end here*****************************************