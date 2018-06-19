package com.example.gging.afinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private Calculation calculation;
    public Record record;

    private class Page extends FragmentPagerAdapter {

        public Page(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    calculation = new Calculation();
                    return calculation;
                case 1:
                    record = new Record();
                    return record;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    private Page page;
    private ViewPager viewPager;

    public String Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = new Page(getSupportFragmentManager());
        viewPager = findViewById(R.id.view_page);
        viewPager.setAdapter(page);
    }
}
