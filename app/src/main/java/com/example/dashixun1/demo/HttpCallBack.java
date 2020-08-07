package com.example.dashixun1.demo;

import android.util.Log;

import com.example.dashixun1.JsonBean;
import com.example.dashixun1.ergedd.ErgeddBean;
import com.example.dashixun1.ergedd.ErgeddResponse;
import com.example.httplibrary1.callback.BaseCallBack;
import com.example.httplibrary1.demo.Response;
import com.google.gson.Gson;
import com.google.gson.JsonElement;



public abstract class HttpCallBack<T> extends BaseCallBack<T> {
  //  Response response;
    ErgeddResponse jsonBean;
    @Override
    protected T onConvert(String result) {
        T t=null;
       /* response = new Gson().fromJson(result, Response.class);
        JsonElement data = response.getData();
        int errorCode = response.getErrorCode();
        String errorMsg = response.getErrorMsg();*/
        jsonBean= new Gson().fromJson(result,ErgeddResponse.class);
        JsonElement data = jsonBean.getRecord();
        int expiration = jsonBean.getStatus();
        JsonElement message = jsonBean.getMessages();


      /*  switch (errorCode) {
            case -1:
                onError(errorMsg,errorCode);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
                break;
        }
        Log.e("2222", "onConvert: "+t.toString() );
        return t;*/
        switch (expiration) {
            case -1:
                onError(new Gson().toJson(message),expiration);
                break;
            default:
                if (isCodeSuccess()) {
                    t=convert(data);
                }
                break;
        }
        Log.e("2222", "onConvert: "+t.toString() );
        return t;
    }


    @Override
    public boolean isCodeSuccess() {
        if (jsonBean != null) {
            return jsonBean.getStatus()== 200;
        }
        return false;
    }

}
