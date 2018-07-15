package com.framgia.moviedb_15.view;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.framgia.moviedb_15.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigationMenu();
    }

    private void initNavigationMenu() {
        mDrawerLayout = findViewById(R.id.drawer_main);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_app_bar, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_home:
                Toast.makeText(this, R.string.home, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_favourite:
                Toast.makeText(this, R.string.favorite, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_popular:
                Toast.makeText(this, R.string.popular, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_topRate:
                Toast.makeText(this, R.string.top_rate, Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_upcoming:
                Toast.makeText(this, R.string.upcoming, Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, R.string.home, Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}
