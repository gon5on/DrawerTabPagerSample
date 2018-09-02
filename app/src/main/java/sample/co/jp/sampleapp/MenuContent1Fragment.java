package sample.co.jp.sampleapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MenuContent1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_menu_content1, container, false);

        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuContent2Fragment fragment = new MenuContent2Fragment();     //本当はファクトリーメソッドを使用してインスタンス化

                //バックスタックに貯めつつ、フラグメントを開く
                getFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack("CONTENT2").commit();
            }
        });

        return view;
    }
}