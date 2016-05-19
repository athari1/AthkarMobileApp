package com.ites.makkahleave.athkar;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Athkar_Mase2 extends AppCompatActivity {


    private List<THekr> mModels;
    private RecyclerView mRecyclerView;
    private CardAdapterThekr mCardAdapter;


    private static THekr[] Use = {new THekr("Mohamed", "manager", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),
            new THekr("Hedi", "engineer", R.drawable.home),};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athkar__mase2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.home);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Get access to the custom title view
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        mTitle.setText(R.string.app_name);
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mModels = new ArrayList<>();

        for (THekr t: Use) {
            mModels.add(t);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewemp);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mCardAdapter = new CardAdapterThekr(mModels);
        mRecyclerView.setAdapter(mCardAdapter);
        //TODO search


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_icon:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(Athkar_Mase2.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

