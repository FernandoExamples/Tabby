package com.udemy.fernando.tabby.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.udemy.fernando.tabby.R;
import com.udemy.fernando.tabby.adapters.PagerAdapter;
import com.udemy.fernando.tabby.fragments.ListFragment;
import com.udemy.fernando.tabby.interfaces.FormFragmentCallback;
import com.udemy.fernando.tabby.model.Person;

public class MainActivity extends AppCompatActivity implements FormFragmentCallback {

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setToolbar();
        bindComponents();
        customComponents();
    }

    private  void bindComponents(){
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
    }

    private void setToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void customComponents(){
        tabLayout.addTab(tabLayout.newTab().setText("Form"));
        tabLayout.addTab(tabLayout.newTab().setText("List"));

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos = tab.getPosition();
                viewPager.setCurrentItem(pos);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void createPerson(Person person) {
        ListFragment listFragment = (ListFragment) getSupportFragmentManager().getFragments().get(1);
        listFragment.addPerson(person);
        viewPager.setCurrentItem(1);
    }
}
