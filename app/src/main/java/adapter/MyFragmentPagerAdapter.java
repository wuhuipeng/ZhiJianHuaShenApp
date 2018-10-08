package adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {


    public boolean flag;


    private List<Fragment> fragmentList;
    public MyFragmentPagerAdapter(FragmentManager fm, boolean flag) {
        super(fm);
        this.flag = flag;
    }



    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }
    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        if (flag) {
            bundle.putString("","上");
        }
        else {
            bundle.putString("排序方式","下");
        }
        fragmentList.get(position).setArguments(bundle);

        return fragmentList.get(position);
    }
    @Override
    public int getCount() {
        return fragmentList.size();
    }
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return title[position];
//    }
}