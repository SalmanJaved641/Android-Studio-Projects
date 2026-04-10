package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPaggerAdapter extends FragmentPagerAdapter {

    public ViewPaggerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            return new chats();
        }
        else if (position==1) {
            return new status();
        }
        else {
            return new calls();
        }
    }

    @Override
    public int getCount() {
        return 3;//no of tabs use for position indexing
    }

    @Override
    public CharSequence getPageTitle(int position) {

//        return super.getPageTitle(position);

        if (position == 0){
            return "Chats";
        }
        else if (position==1) {
            return "Status";
        }
        else {
            return "Calls.";
        }
    }

}
