package sample.co.jp.sampleapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //初回フラグメントセット
        TabLayoutFragment fragment = new TabLayoutFragment();     //本当はファクトリーメソッドを使用してインスタンス化
        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        Fragment fragment = getFragmentManager().findFragmentByTag("CONTENT2");

        //ドロワーを開いていたら閉じる
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        //フラグメント
        else if (fragment != null && fragment instanceof BackPressedListener) {
            ((BackPressedListener) fragment).onBackPressed();
        }
        else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            MenuContent1Fragment fragment = new MenuContent1Fragment();     //本当はファクトリーメソッドを使用してインスタンス化
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setBackAllow() {
        //ドロワー無効化
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);

        //ハンバーガーアイコンを無効化
        toggle.setDrawerIndicatorEnabled(false);

        //戻るアイコン表示
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //戻る矢印を押した
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeFragment();
            }
        });
    }

    public void removeFragment() {
        //fragmentを一つ取り除く
        getSupportFragmentManager().popBackStack();

        //戻るアイコン非表示
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        //ハンバーガーアイコン有効化
        toggle.setDrawerIndicatorEnabled(true);

        //ドロワー有効化
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }
}
