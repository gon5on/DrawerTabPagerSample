package sample.co.jp.sampleapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ListViewHeaderPagerAdapter extends FragmentPagerAdapter {
    private CharSequence[] slide = {"slide1", "slide2", "slide3"};

    public ListViewHeaderPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return slide[position];
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("POSITION", position);

        Fragment fragment = new PagerViewFragment();    //ファクトリーメソッドでインスタンス化すること
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return slide.length;
    }
}