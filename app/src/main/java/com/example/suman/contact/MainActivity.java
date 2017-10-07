package com.example.suman.contact;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.suman.contact.ChangeProfile.UserProfile;
import com.example.suman.contact.Fragments.FragmentFav;
import com.example.suman.contact.Fragments.FragmentMycontacts;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    //DrawerLayout drawerLayout;
    ActionBarDrawerToggle mToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView = (NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               // drawerLayout.closeDrawers();
                switch (item.getItemId()){
                    case R.id.nav_account:

                        FragmentManager fm = getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.replace(R.id.fragment, new FragmentFav());
                        //ft. addToBackStack("fm");
                        ft.commit();
                        item.setCheckable(true);
                        break;
                    case R.id.nav_logout:

                        FragmentManager fm2 = getSupportFragmentManager();
                        FragmentTransaction ft2 = fm2.beginTransaction();
                        ft2.replace(R.id.fragment, new FragmentMycontacts());
                        //ft2. addToBackStack("fm2");
                        ft2.commit();
                        item.setCheckable(true);
                        break;
                    case R.id.nav_setting:

                        FragmentManager fm3 = getSupportFragmentManager();
                        FragmentTransaction ft3 = fm3.beginTransaction();
                        ft3.replace(R.id.fragment, new FragmentFav());
                        //ft3. addToBackStack("fm3");
                        ft3.commit();
                        item.setCheckable(true);
                        break;
                }
                return true;
            }
        });
       // mToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
       // drawerLayout.setDrawerListener(mToggle);
       // mToggle.syncState();
       // getSupportActionBar();//.setDisplayHomeAsUpEnabled(true);

        FragmentManager fms = getSupportFragmentManager();
        FragmentTransaction fts = fms.beginTransaction();
        fts.replace(R.id.fragment, new FragmentMycontacts());
        fts.commit();
        navigationView.getMenu().findItem(R.id.nav_logout).setChecked(true);


//        navigationView.inflateHeaderView(R.layout.navigation_layout).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"okkkk",Toast.LENGTH_LONG).show();
//            }
//        });

        navigationView.inflateHeaderView(R.layout.navigation_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userProfileIntent = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(userProfileIntent);
            }
        });

    }

    @Override
    protected void onRestart() {
        super.onRestart();
       ImageView i = (ImageView) navigationView.findViewById(R.id.imageView);
       i.setImageResource(R.drawable.suman);
    }
}
