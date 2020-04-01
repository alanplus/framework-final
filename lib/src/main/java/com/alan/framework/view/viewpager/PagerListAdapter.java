package com.alan.framework.view.viewpager;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class PagerListAdapter<T extends Fragment> extends FragmentStatePagerAdapter {

    private List<T> mFragmentList = new ArrayList<>();

    public PagerListAdapter(FragmentManager fm, List<T> mFragments) {
        super(fm);
        mFragmentList = mFragments;
    }
    
    @Override
    public Parcelable saveState()
    {
        return null;
    }

    @Override
    public T getItem(int position) {
        return mFragmentList.get(position % getCount());
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerListAdapter.POSITION_NONE;
    }
}