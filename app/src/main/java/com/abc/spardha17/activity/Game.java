package com.abc.spardha17.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.abc.spardha17.R;
import com.abc.spardha17.fragments.GameActivity.FourFragmentGame;
import com.abc.spardha17.fragments.GameActivity.OneFragmentGame;
import com.abc.spardha17.fragments.GameActivity.ThreeFragmentGame;
import com.abc.spardha17.fragments.GameActivity.TwoFragmentGame;
import com.abc.spardha17.fragments.Strings.strings;

import java.util.ArrayList;
import java.util.List;

public class Game extends AppCompatActivity {


    int position=0;
    CollapsingToolbarLayout mainImage;
    strings item=new strings();
   String[] titles =item.titles;
    int[] images = item.images;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
//        Bundle extras=getIntent().getExtras();
        position=getIntent().getExtras().getInt("position");
//        System.out.println("position is "+position);
//        getActionBar().setTitle(titles[position]);
        getSupportActionBar().setTitle(titles[position]);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        mainImage = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout1);
        mainImage.setBackgroundResource(images[position]);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.viewpager1);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs1);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(4);
        Fragment fixtures=new OneFragmentGame();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fixtures.setArguments(bundle);
        adapter.addFragment(fixtures, "FIXTURES");

        Fragment results=new TwoFragmentGame();
        results.setArguments(bundle);
        adapter.addFragment(results, "RESULTS");

        Fragment contacts=new ThreeFragmentGame();
        contacts.setArguments(bundle);
        adapter.addFragment(contacts, "CONTACTS");

        Fragment fame=new FourFragmentGame();
        fame.setArguments(bundle);
        adapter.addFragment(fame,"HALL OF FAME");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
