package com.example.innorevaresourcemanager.ui.DomainModule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerDomainAdapter extends FragmentPagerAdapter {

    public ViewPagerDomainAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new About2Fragment();
        } else if (position == 1) {
            return new ResourceFragment();
        } else{
            return new MentorFragment();
        }
    }



    @Override
    public int getCount() {
        return 3;  //no.of tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "Overview";
        }
        else if(position==1){
            return "Resource";
        }
        else{
            return "Mentor";
        }
    }
}
