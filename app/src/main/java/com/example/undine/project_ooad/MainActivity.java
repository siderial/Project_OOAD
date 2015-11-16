package com.example.undine.project_ooad;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.PopupMenu;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    private Context context;

    private int[] imageResId = {
            R.drawable.ic_home_black,
            R.drawable.ic_noti_black,
            R.drawable.ic_schedule_black,
            R.drawable.ic_account_black
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Pin Up");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(false);


        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();
        setupTitle(tabLayout);

    }

    private void setupTitle(TabLayout tab ){
        if(tab.getSelectedTabPosition()== 3){
            toolbar.setTitle("Account");
        }

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(imageResId[0]);
        tabLayout.getTabAt(1).setIcon(imageResId[1]);
        tabLayout.getTabAt(2).setIcon(imageResId[2]);
        tabLayout.getTabAt(3).setIcon(imageResId[3]);
    }

        private void setupViewPager(ViewPager viewPager) {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new NewFeed(), "New");
            adapter.addFragment(new Noiti(), "Noti");
            adapter.addFragment(new Schedule(), "Schdule");
            adapter.addFragment(new ManageAccount(), "Account");
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
                return null;
            }
        }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        View miniView = findViewById(R.id.toolbar);

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_action) {
            startActivity(new Intent(this,Search.class));
            return true;
        }
        if (id == R.id.write_action) {
            startActivity(new Intent(this,AddEvent.class));
            return true;
        }
        if (id == R.id.sort_action) {
            PopupMenu menuSort = new PopupMenu(this,miniView);
            menuSort.setGravity(Gravity.RIGHT);
            menuSort.getMenuInflater().inflate(R.menu.menu_sort, menuSort.getMenu());
            menuSort.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    int id = item.getItemId();

                    if(id == R.id.postTime){
                        Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }


                    if(id == R.id.alpha){
                        Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    if(id == R.id.rate){
                        Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    if(id == R.id.eventStart){
                        Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }


                    return false;
                }
            });

            menuSort.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
