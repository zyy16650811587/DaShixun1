package com.example.mvplibrary.base;

import com.example.mvplibrary.present.BasePresent;
import com.example.mvplibrary.view.BaseView;

public abstract class BaseMvpActivity<V extends BaseView,P extends BasePresent<V>> extends BaseActivity{
    public P mPresent;
    @Override
    protected void initEvEnt() {
        mPresent=intiPresent();
        if(mPresent !=null){
            mPresent.attachView((V)this);
        }
    }

    protected abstract P intiPresent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresent!=null){
            mPresent.destoryView();
            mPresent=null;
        }
    }
}
