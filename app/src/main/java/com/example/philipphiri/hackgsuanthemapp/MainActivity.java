package com.example.philipphiri.hackgsuanthemapp;

import android.content.Intent;

import android.graphics.drawable.Drawable;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton one, two, three, four, five;
    public static boolean butOne, butTwo, butThree, butFour, butFive;
    private List<ImageButton> buttons;
    private Button whyButton;
    //testing

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mTog;
    private TextView warning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
//        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mTog);
//        mTog.syncState();
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        warning = findViewById(R.id.warning);
        one = (ImageButton) findViewById(R.id.imageButton1);
        findViewById(R.id.imageButton1).setOnClickListener(this);
        two = (ImageButton) findViewById(R.id.imageButton2);
        findViewById(R.id.imageButton2).setOnClickListener(this);
        three = (ImageButton) findViewById(R.id.imageButton3);
        findViewById(R.id.imageButton3).setOnClickListener(this);
        four = (ImageButton) findViewById(R.id.imageButton4);
        findViewById(R.id.imageButton4).setOnClickListener(this);
        five = (ImageButton) findViewById(R.id.imageButton5);
        findViewById(R.id.imageButton5).setOnClickListener(this);

        buttons = new ArrayList<>();
        buttons.add(one);
        buttons.add(two);
        buttons.add(three);
        buttons.add(four);
        buttons.add(five);

        butOne = true;
        butTwo = true;
        butThree = true;
        butFour = true;
        butFive = true;

        whyButton = (Button)findViewById(R.id.why_button);
        whyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!(butOne && butTwo && butThree && butFour && butFive)) {
                    startActivity(new Intent(MainActivity.this,emoji_response.class));
                 } else {
                    warning.setVisibility(View.VISIBLE);
                }
            }
        });


//
//
//        one.setOnClickListener(new View.OnClickListener()
//        {
//
//            @Override
//            public void onClick(View v) {
//                if (off) {
//                    float x = (float) 1.25;
//                    float y = (float) 1.25;
//
//                    one.setScaleX(x);
//                    one.setScaleY(y);
//                    one.setBackgroundResource(R.drawable.one);
//                    off = false;
//                } else {
//                    float x = 1;
//                    float y = 1;
//
//                    one.setScaleX(x);
//                    one.setScaleY(y);
//                    one.setBackgroundResource(R.drawable.one);
//
//
//                    off = true;
//                }
//            }
//        });
//
//
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imageButton1) {
           enlarge(one, R.drawable.one, R.id.imageButton1, butOne);
           view.bringToFront();
           TextView description;
           description = findViewById(R.id.emoji_desc);
           description.setText("I am feeling exhausted..");
            butOne = !butOne;
            butTwo = true;
            butThree = true;
            butFour = true;
            butFive = true;
            if (!butOne) {
                warning.setVisibility(View.INVISIBLE);
            }
        } else if (view.getId() == R.id.imageButton2) {
            enlarge(two, R.drawable.two, R.id.imageButton2, butTwo);
            view.bringToFront();
            TextView description;
            description = findViewById(R.id.emoji_desc);
            description.setText("I am feeling anxious");
            butOne = true;
            butTwo = !butTwo;
            butThree = true;
            butFour = true;
            butFive = true;
            if (!butTwo) {
                warning.setVisibility(View.INVISIBLE);
            }
        } else if (view.getId() == R.id.imageButton3) {
            enlarge(three, R.drawable.three, R.id.imageButton3, butThree);
            view.bringToFront();
            TextView description;
            description = findViewById(R.id.emoji_desc);
            description.setText("I am feeling content");
            butOne = true;
            butTwo = true;
            butThree = !butThree;
            butFour = true;
            butFive = true;
            if (!butThree) {
                warning.setVisibility(View.INVISIBLE);
            }
        } else if (view.getId() == R.id.imageButton4) {
            enlarge(four, R.drawable.four, R.id.imageButton4, butFour);
            view.bringToFront();
            TextView description;
            description = findViewById(R.id.emoji_desc);
            description.setText("I am feeling happy");
            butOne = true;
            butTwo = true;
            butThree = true;
            butFour = !butFour;
            butFive = true;
            if (!butFour) {
                warning.setVisibility(View.INVISIBLE);
            }
        } else if (view.getId() == R.id.imageButton5) {
            enlarge(five, R.drawable.five, R.id.imageButton5, butFive);
            view.bringToFront();
            TextView description;
            description = findViewById(R.id.emoji_desc);
            description.setText("I am feeling excited!");
            butOne = true;
            butTwo = true;
            butThree = true;
            butFour = true;
            butFive = !butFive;
            if (!butFive) {
                warning.setVisibility(View.INVISIBLE);
            }
        }

    }

    private void enlarge(ImageButton but, int background, int idd, boolean bbutton)  {
        Log.d("BUTTON!", bbutton + " ");
        if (bbutton) {
            float x = (float) 1.25;
            float y = (float) 1.25;

            but.setScaleX(x);
            but.setScaleY(y);
            //but.setBackgroundResource(background);
        } else {
            float x = 1;
            float y = 1;

            but.setScaleX(x);
            but.setScaleY(y);
            //but.setBackgroundResource(background);
        }

        for(ImageButton button: buttons) {
            if(button.getId() != idd) {
                float x = 1;
                float y = 1;

                button.setScaleX(x);
                button.setScaleY(y);
                //button.setBackgroundResource(background);
            }
        }

    }

    private void initInstances() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mTog = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mTog);
        mTog.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigation;

        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.myVitals:
                        startActivity(new Intent(MainActivity.this, Vitals_Activity.class));
                        break;
                    case R.id.teamVitals:
                        startActivity(new Intent(MainActivity.this, TeamVitals_Activity.class));
                        break;
                    case R.id.companyVitals:
                        startActivity(new Intent(MainActivity.this, CompanyVitals_Activity.class));
                        break;
                    case R.id.about:
                        startActivity(new Intent(MainActivity.this, aboutPage.class));
                        // add navigation drawer item onclick method here
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mTog.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
