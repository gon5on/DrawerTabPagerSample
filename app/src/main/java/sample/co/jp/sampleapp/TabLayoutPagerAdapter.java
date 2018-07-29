package sample.co.jp.sampleapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabLayoutPagerAdapter extends FragmentPagerAdapter {
    private CharSequence[] tabTitles = {"tab1", "tab2"};

    public TabLayoutPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabContent1Fragment();   //ファクトリーメソッドでインスタンス化すること
            case 1:
                return new TabContent2Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }
}