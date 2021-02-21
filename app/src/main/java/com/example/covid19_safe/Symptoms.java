package com.example.covid19_safe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Symptoms extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.symptoms);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav=(NavigationView)findViewById(R.id.navmenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.menu_home :
                        Toast.makeText(getApplicationContext(),"Dashboard",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent = new Intent(getApplicationContext(), Dashboard.class);// New activity
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                        break;

                    case R.id.menu_breakdown :
                        Toast.makeText(getApplicationContext(),"Breakdown of the situation",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent1 = new Intent(getApplicationContext(), Breakdown.class);// New activity
                        intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.menu_worldwide :
                        Toast.makeText(getApplicationContext(),"Worldwide updates",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2 = new Intent(getApplicationContext(), Worldwide.class);// New activity
                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        finish();
                        break;

                    case R.id.menu_sysmptoms :
                        Toast.makeText(getApplicationContext(),"Covid 19 symptoms",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.menu_treatments :
                        Toast.makeText(getApplicationContext(),"Prevention and treatments",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent3 = new Intent(getApplicationContext(), Treatments.class);// New activity
                        intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        finish();
                        break;
                }
                return true;
            }
        });
    }
}


