package sample.co.jp.sampleapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TabContent1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_tab_content1, container, false);

        //アダプタ作成
        String[] data = {"あいうえお", "かきくけこ", "さしすせそ", "たちつてと", "なにぬねの",
                "あいうえお", "かきくけこ", "さしすせそ", "たちつてと", "なにぬねの",
                "あいうえお", "かきくけこ", "さしすせそ", "たちつてと", "なにぬねの",
                "あいうえお", "かきくけこ", "さしすせそ", "たちつてと", "なにぬねの"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, data);

        //ヘッダ設定
        View header = View.inflate(getActivity(), R.layout.part_listview_header, null);
        ViewPager pager = header.findViewById(R.id.viewPager);

        ListViewHeaderPagerAdapter adapter2 = new ListViewHeaderPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter2);

        //リストビューにセット
        ListView listView = view.findViewById(R.id.listView);
        listView.addHeaderView(header);
        listView.setAdapter(adapter);

        return view;
    }
}