package com.palmintelligence.administrator.nethardnewsv001;

import android.support.v4.app.Fragment;

import android.os.Bundle;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.palmintelligence.administrator.nethardnewsv001.fragment.ChinaFragment;
import com.palmintelligence.administrator.nethardnewsv001.fragment.EconomicFragment;
import com.palmintelligence.administrator.nethardnewsv001.fragment.EntertainmentFragment;
import com.palmintelligence.administrator.nethardnewsv001.fragment.FashionFragment;
import com.palmintelligence.administrator.nethardnewsv001.fragment.GamesFragment;
import com.palmintelligence.administrator.nethardnewsv001.fragment.NewsFragment;
import com.palmintelligence.administrator.nethardnewsv001.fragment.SocietyFragment;
import com.palmintelligence.administrator.nethardnewsv001.fragment.SportFragment;

import com.palmintelligence.administrator.nethardnewsv001.fragment.WarsFragment;
import com.palmintelligence.administrator.nethardnewsv001.ui.ViewPagerIndicate;

import java.util.ArrayList;

import butterknife.Bind;


public class MainActivity extends BaseActivity {
    @SuppressWarnings("unused")
    @Bind(R.id.indicate)
    ViewPagerIndicate tabPageIndicator;

    @SuppressWarnings("unused")
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    private ArrayList<Fragment> fragmentList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      initViewPagerIndicate();

  // replaceFragment(new NewsFragment());

        InitViewPager();

    }

    protected int getLayoutId(){
        return R.layout.activity_main;

    }


    private void InitViewPager(){
        fragmentList = new ArrayList<Fragment>();

        NewsFragment newsFragment=new NewsFragment();

        EconomicFragment economicFragment=new EconomicFragment();

        GamesFragment gamesFragment =new GamesFragment();

        SportFragment sportFragment = new SportFragment();

        SocietyFragment societyFragment= new SocietyFragment();

        EntertainmentFragment entertainmentFragment=new EntertainmentFragment();

        WarsFragment warsFragment=new WarsFragment();

        FashionFragment fashionFragment=new FashionFragment();

        ChinaFragment chinaFragment=new ChinaFragment();

        fragmentList.add(newsFragment);
        fragmentList.add(gamesFragment);
        fragmentList.add(sportFragment);
        fragmentList.add(economicFragment);
        fragmentList.add(societyFragment);
        fragmentList.add(entertainmentFragment);
        fragmentList.add(warsFragment);
        fragmentList.add(fashionFragment);
        fragmentList.add(chinaFragment);

            viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
                @Override
                public Fragment getItem(int position) {
                    return fragmentList.get(position);
                }

                @Override
                public int getCount() {
                    return fragmentList.size();
                }
            });
    }


  //初始化顶部滑动
    private void initViewPagerIndicate() {

      int[] mTextColors = {0xFFA0A0A0, 0xFF000000};
      int mUnderlineColor = 0xFF168EFF;
       String[] mTitles = new String[] {
                "要闻", "科技", "体育", "经济","社会","娱乐","军事","时尚","国内","测试1","测试2","测试3"
               };
        tabPageIndicator.resetText(R.layout.viewpagerindicate_item, mTitles, mTextColors);
        //设置下划线粗细和颜色
        tabPageIndicator.resetUnderline(4, mUnderlineColor);
        //设置ViewPager
        tabPageIndicator.resetViewPager(viewPager);
        //设置初始化完成
        tabPageIndicator.setOk();
    }


    void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, fragment).commit();
    }

}
