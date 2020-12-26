package com.example.lesson6_fragments_27;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {

    public Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TextFragment();
            case 1:
                return new ChangeFragment();
            case 2:
                return new ChildFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
