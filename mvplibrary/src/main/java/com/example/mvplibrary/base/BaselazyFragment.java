package com.example.mvplibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvplibrary.present.BasePresent;
import com.example.mvplibrary.view.BaseView;

import androidx.annotation.Nullable;

public abstract class BaselazyFragment<V extends BaseView,P extends BasePresent<V>> extends BaseFragment {
  boolean mIsPrepare=false;   //初始化视图
  boolean mIsVisble=false;
  boolean mIsFistLoad=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        mIsPrepare=true;
        LazyLoad();

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            mIsVisble=true;
            LazyLoad();
        }else {
            mIsVisble=false;
        }
    }

    private void LazyLoad() {
        if(mIsPrepare && mIsVisble && mIsFistLoad){
            lazyinitLoad();
            mIsFistLoad=false;
        }
    }

    protected abstract void lazyinitLoad();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       mIsPrepare=false;
       mIsVisble=false;
       mIsFistLoad=true;
    }
}
