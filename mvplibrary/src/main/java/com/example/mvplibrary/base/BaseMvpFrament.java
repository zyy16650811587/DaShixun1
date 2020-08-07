package com.example.mvplibrary.base;

import com.example.mvplibrary.present.BasePresent;
import com.example.mvplibrary.view.BaseView;

public abstract class BaseMvpFrament<V extends BaseView,P extends BasePresent> extends BaseFragment{
    private  P mPresent;
    @Override
    protected void initData() {
        mPresent=initPresent();
        if(mPresent!=null){
            mPresent.attachView((BaseView) this);

        }

    }

    protected abstract P initPresent();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresent!=null){
            mPresent.destoryView();
            mPresent=null;
        }
    }
}
