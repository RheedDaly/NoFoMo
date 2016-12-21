package com.thetechaupair.nofomo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class TabPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<Fragment>();

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public long getItemId(int position) {
        return fragments.indexOf(getItem(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = fragments.get(position).toString();
        return title.toString();
    }
}
