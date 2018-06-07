package com.masbon.wallpaperhd;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class viewPagerAdapter extends FragmentStatePagerAdapter{

    public static int PAGER_LENGTH = 5 ;

    public viewPagerAdapter(FragmentManager fm) {
        super(fm);
// TODO Auto-generated constructor stub
    }

    @Override
    public Fragment getItem(int arg0) {
// TODO Auto-generated method stub
        return CustomPager.create(arg0);
    }

    @Override
    public int getCount() {
// TODO Auto-generated method stub
        return PAGER_LENGTH;
    }

}