package com.example.mvplibrary.base;

import android.os.Bundle;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends RxAppCompatActivity {

    private Unbinder unBinder;
//创建布局
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initlayoutId());
        unBinder = ButterKnife.bind(this);
        initData();
        initEvEnt();
    }

    protected abstract void initEvEnt();

    protected abstract void initData();

    protected abstract int initlayoutId();
//销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(unBinder!=null){
            unBinder.unbind();
        }
    }
}
