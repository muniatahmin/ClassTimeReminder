package com.example.classtimereminder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static LinearLayout layoutHolder;
    private static LinearLayout[] layoutHolderArray;
    private static TextView[] textHolder;
    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v, "See Whole Week Routine", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                return true;
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        initView();
        setListeners();
/**
        //Creating LinearLayout.
        LinearLayout linearlayout = new LinearLayout(this);

        //Setting up LinearLayout Orientation
        linearlayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams linearlayoutlayoutparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        setContentView(linearlayout, linearlayoutlayoutparams);

        LinearLayout.LayoutParams LayoutParamsview = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //Creating textview .
        TextView SampleTextView1 = new TextView(this);
        TextView SampleTextView2 = new TextView(this);

        //Adding text to TextView.
        SampleTextView1.setText("First TextView Text");
        SampleTextView2.setText("Second TextView Text");

        //Setting TextView text Size
        SampleTextView1.setTextSize(25);
        SampleTextView2.setTextSize(25);

        SampleTextView1.setLayoutParams(LayoutParamsview);
        SampleTextView2.setLayoutParams(LayoutParamsview);

        //Adding textview to linear layout using Add View function.
        linearlayout.addView(SampleTextView1);
        linearlayout.addView(SampleTextView2);
*/
    }

    private void setListeners() {
        layoutHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLayoutHolder();
            }
        });
    }

    private void initView() {
        layoutHolder = (LinearLayout) findViewById(R.id.linearLayoutContent);
    }

//    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.linearLayoutContent:
                showLayoutHolder();
                break;

            case 0:
                ((TextView) view).setText("Text Changed");
                break;
            case 1:
                ((TextView) view).setText("Text Changed");
                break;
            case 2:
                ((TextView) view).setText("Text Changed");
                break;
            case 3:
                ((TextView) view).setText("Text Changed");
                break;
            case 4:
                ((TextView) view).setText("Text Changed");
                break;
        }
    }

    private void showLayoutHolder() {
        layoutHolder.removeAllViews();//Remove all View from layout
        textHolder = new TextView[3];//init size of TextView array
        LayoutInflater in = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);//Layout inflater for inflating layout views
        layoutHolderArray = new LinearLayout[3];
        //Loop for 3 items
        for (int i = 0; i < 3; i++) {
            View v = in.inflate(R.layout.customlayout, null);//Getting xml view
            TextView text = (TextView) v.findViewById(R.id.customTextView);//Finding Id of textView
            text.setId(i);//Setting id of textview
            text.setText("Text " + i);//setting text
/*
            layoutHolderArray[i].setOrientation(LinearLayout.HORIZONTAL);
//            layoutHolderArray[i].;
            android.view.ViewGroup.LayoutParams linearParams = new android.view.ViewGroup.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutHolderArray[i].setLayoutParams(linearParams);
            layoutHolderArray[i].addView(text,0);
*/
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((TextView) v).setText("Text Changed");
                }});//implementing click listener
            textHolder[i] = text;//Setting text reference for future use
            layoutHolder.setOrientation(LinearLayout.HORIZONTAL);//Setting layout orientation
            layoutHolder.addView(v);
        }

    }
    public void onClickSetClass(View v)
    {
        Intent intentSetClass=new Intent(this,SetClassActivity.class);
        startActivity(intentSetClass);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void onClickFab(View v)
    {
        Intent intentRoutine=new Intent(this,Routine.class);
        startActivity(intentRoutine);
    }
}

