package com.example.covid19_safe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Worldwide extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worldwide);

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
                        break;

                    case R.id.menu_sysmptoms :
                        Toast.makeText(getApplicationContext(),"Covid 19 symptoms",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        Intent intent2 = new Intent(getApplicationContext(), Symptoms.class);// New activity
                        intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent2);
                        finish();
                        break;

                    case R.id.menu_treatments :
                        Toast.makeText(getApplicationContext(),"Covid 19 symptoms",Toast.LENGTH_LONG).show();
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
        myWebView = (WebView) findViewById(R.id.worldwide);
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onLoadResource(WebView view, String url) {
                try {
                    myWebView.loadUrl("javascript:(window.onload = function() { " +
                            "(elem1 = document.getElementsByClassName('vs-row pb-2')); while(elem1.length > 0){\n" +
                            "        elem1[0].parentNode.removeChild(elem1[0]);\n" +
                            "    }; " +
                            "(elem2 = document.getElementsByClassName('main-topic')); while(elem2.length > 0){\n" +
                            "        elem2[0].parentNode.removeChild(elem2[0]);\n" +
                            "    }; " +
                            "(elem3 = document.getElementsByClassName('vs-col vs-xs- vs-sm-12 vs-lg-3')); while(elem3.length > 0){\n" +
                            "        elem3[0].parentNode.removeChild(elem3[0]);\n" +
                            "   }; " +
                            "(elem4 = document.getElementById('daily_cases')); elem4.parentNode.removeChild(elem4); " +
                            "(elem5 = document.getElementById('growth_rate')); elem5.parentNode.removeChild(elem5); " +
                            "(elem6 = document.getElementsByClassName('set-animation from-top animate')); while(elem6.length > 0){\n" +
                            "        elem6[0].parentNode.removeChild(elem6[0]);\n" +
                            "   }; " +
                            "(elem7 = document.getElementsByClassName('vs-col vs-xs- vs-sm-12 vs-lg-4')); while(elem7.length > 0){\n" +
                            "        elem7[0].parentNode.removeChild(elem7[0]);\n" +
                            "   }; " +
                            "(elem8 = document.getElementsByClassName('vs-col vs-xs- vs-sm-12 vs-lg-12')); while(elem8.length > 0){\n" +
                            "        elem8[0].parentNode.removeChild(elem8[0]);\n" +
                            "   }; " +
                            "})()");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        myWebView.loadUrl("https://hpb.health.gov.lk/covid19-dashboard/");
    }
}
