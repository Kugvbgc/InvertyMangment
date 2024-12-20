package com.khair.invertymangment.onboarding;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class OnboardingAdapter extends FragmentStateAdapter {

    private List<OnboardingModel> tab;

    public OnboardingAdapter(@NonNull FragmentActivity fragmentActivity,List<OnboardingModel>tab) {
        super(fragmentActivity);
        this.tab=tab;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        try {

            return tab.get(position).getFragmentclass().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace(); // Log the error
            return new Fragment(); // Return a fallback fragment
        }
    }

    @Override
    public int getItemCount() {
        return tab.size();
    }
}
