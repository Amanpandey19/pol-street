package com.pollstreet.polstreet.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class BetTabsAdapter extends FragmentStateAdapter {


    public BetTabsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 1:
                return new NewsBetFragment();
            default:
                return new AboutBetFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
