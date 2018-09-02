package sample.co.jp.sampleapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class MenuContent2Fragment extends Fragment implements BackPressedListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        //戻るボタン表示
        ((MainActivity) getActivity()).setBackAllow();

        return inflater.inflate(R.layout.fragment_menu_content2, container, false);
    }

    @Override
    public void onBackPressed() {
        //フラグメントを終了
        ((MainActivity) getActivity()).removeFragment();
    }
}