package com.myapplicationdev.android.p10_fragment_swipe_menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList <Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button btnChange, btnRead;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vPager = findViewById(R.id.viewPager);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new Frag1());
        al.add(new Frag2());

        adapter = new MyFragmentPagerAdapter(fm, al);
        vPager.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.previous:
                if (vPager.getCurrentItem() >0){
                    int prevPage = vPager.getCurrentItem() - 1;
                    vPager.setCurrentItem(prevPage, true);
                }
                return true;
            case R.id.random:
                Random randoms = new Random();
                int ranPage = randoms.nextInt(al.size());
                vPager.setCurrentItem(ranPage, true);
                return true;
            case R.id.next:
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max - 1){
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
}