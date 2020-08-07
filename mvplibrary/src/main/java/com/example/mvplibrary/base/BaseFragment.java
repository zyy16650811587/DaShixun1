package com.example.mvplibrary.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.RxFragment;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public  abstract class BaseFragment extends RxFragment {
   public Activity mActivity;
   public Context context;
   private View rootview;
   private Unbinder unbinder;
//初始化界面
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity= (Activity) context;
        this.context=context;
    }
//加载布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       if(rootview!=null){
           rootview=inflater.inflate(initLayout(),null);
       }
       unbinder= ButterKnife.bind(this,rootview);

        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract int initLayout();
//调用销毁方法（解绑）
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(rootview!=null){
           // ((ViewGroup) rootview.getParent()).removeView(rootview);
            ((ViewGroup)rootview.getParent()).removeView(rootview);
        }
        if(unbinder!=null){
            unbinder.unbind();
        }
    }
}
