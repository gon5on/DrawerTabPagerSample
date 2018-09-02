package sample.co.jp.sampleapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabLayoutPagerAdapter extends FragmentPagerAdapter {
    private CharSequence[] tabTitles = {"tab1tab1", "tab2tab2", "tab3tab3", "tab4tab4", "tab5tab5"};

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
                return new TabContent2Fragment();
            case 1:
                return new TabContent2Fragment();
            case 2:
                return new TabContent1Fragment();   //ファクトリーメソッドでインスタンス化すること
            case 3:
                return new TabContent2Fragment();
            case 4:
                return new TabContent2Fragment();
            case 5:
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