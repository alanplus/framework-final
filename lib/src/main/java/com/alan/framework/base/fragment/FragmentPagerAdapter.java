package com.alan.framework.base.fragment;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;


public class FragmentPagerAdapter<T extends Fragment> extends FragmentStatePagerAdapter {

    private T[] mFragmentList;

    public FragmentPagerAdapter(FragmentManager fm, T[] mFragments) {
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
        return mFragmentList[position % getCount()];
    }

    @Override
    public int getCount() {
        return mFragmentList.length;
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
        return PagerAdapter.POSITION_NONE;
    }
}