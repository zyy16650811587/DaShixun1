package com.example.dashixun1.ergedd;

import com.example.dashixun1.ergedd.ErgeddResponse;
import com.example.httplibrary1.callback.BaseCallBack;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class ErgeddCallback<T> extends BaseCallBack<T> {
    ErgeddResponse ergeddResponse;
    @Override
    protected T onConvert(String result) {
        T t=null;
        ergeddResponse=new Gson().fromJson(result,ErgeddResponse.class);
        JsonElement data = ergeddResponse.getRecord();
        JsonElement messages = ergeddResponse.getMessages();
        int status = ergeddResponse.getStatus();
        switch (status){
            case -1:
               onError(new Gson().toJson(messages),status);
               break;
            default:
               if(isCodeSuccess()){
                   t=convert(data);
               }
               break;
        }
        return t;
    }

    @Override
    public boolean isCodeSuccess() {
        if (ergeddResponse != null) {
            return ergeddResponse.getStatus() == 200;
        }
        return false;
    }


}
