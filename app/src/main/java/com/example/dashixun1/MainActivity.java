package com.example.dashixun1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.dashixun1.demo.HttpCallBack;
import com.example.dashixun1.ergedd.ErgeddBean;
import com.example.httplibrary1.client.HttpClient;
import com.example.httplibrary1.utils.JsonUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //   initData1();
        initData2();
      /*  ApiServer apiServer = HttpManager.getInstance()
                .getrerofit("https://wanandroid.com/", 5, TimeUnit.SECONDS)
                .create(ApiServer.class);
        Observable<JsonElement> get = apiServer.get("article/listproject/0/json", new HashMap<String, Object>(), new HashMap<String, Object>());

        get.delay(5,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Function<Throwable, ObservableSource<? extends JsonElement>>() {
                    @Override
                    public ObservableSource<? extends JsonElement> apply(Throwable throwable) throws Exception {
                        return Observable.error(new Exception(""));
                    }
                })
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.e(TAG, "run: "+"取消了订阅" );
                    }
                })
                .map(new Function<JsonElement, ResponseBean>() {
                    @Override
                    public ResponseBean apply(JsonElement jsonElement) throws Exception {
                        ResponseBean responseBean = new Gson().fromJson(jsonElement.toString(), ResponseBean.class);
//                        Log.e(TAG, "apply: "+responseBean.toString() );
                        return responseBean;
                    }
                })
                .map(new Function<ResponseBean, Demo>() {
                    @Override
                    public Demo apply(ResponseBean responseBean) throws Exception {
                        String s = new Gson().toJson(responseBean.getData());
                        Demo demo = new Gson().fromJson(s, Demo.class);
                        return demo;
                    }
                })
                .subscribe(new Observer<Demo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Demo demo) {
                        Log.e(TAG, "onNext: "+demo.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
      /*  new HttpClient.Builder()
                .setApiUrl("project/list/1/json?cid=294")
                .get()
                .build()
                .request(new HttpCallBack<Demo>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("111", "onError: " + code);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    protected void onSuccess(Demo demo) {
                        Log.e("111", "onSuccess: " + demo.toString());
                    }

                    @Override
                    public Demo convert(JsonElement result) {
                        return new Gson().fromJson(new Gson().toJson(result), Demo.class);
                    }
                });*/


    }

    private void initData2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("limit", 10);
        HashMap<String, Object> heardMap = new HashMap<>();
        heardMap.put("Cache-Control", "public");
        heardMap.put("max-age", "28800");
        new HttpClient.Builder()
//                .setApiUrl("getVideoSearchKeyword?limit=2")
                .setApiUrl("getVideoSearchKeyword")
                .post()
                .setJsonBody("", false)
                .setParamser(map)
                .setHeadres(heardMap)
                .build()
                .request(new HttpCallBack<List<String>>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("111", "onError: " + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    protected void onSuccess(List<String> ergeddBeans) {
                        Log.e("111", "onSuccess: " + ergeddBeans.toString());
                    }

                    @Override
                    public List<String> convert(JsonElement result) {
                        ErgeddBean ergeddBean = JsonUtils.jsonToClass(result, ErgeddBean.class);
                        return  ergeddBean.getKeywords();
                    }
                });

    }

    private void initData1() {
        new HttpClient.Builder()
                .setApiUrl("magnets")
                .get()
                .build()
                .request(new HttpCallBack<List<JavaBean>>() {
                    @Override
                    public void onError(String message, int code) {
                        Log.e("111", "onError: " + message);
                    }

                    @Override
                    public void cancle() {

                    }

                    @Override
                    protected void onSuccess(List<JavaBean> javaBeans) {
                        Log.e("111", "onSuccess: " + javaBeans.toString());
                    }

                    @Override
                    public List<JavaBean> convert(JsonElement result) {
                        String s = new Gson().toJson(result
                        );
                        JavaBean javaBean = new Gson().fromJson(s, JavaBean.class);

                        List<JavaBean> javaBeans = JsonUtils.jsonToClassList(result, JavaBean.class);
                        return javaBeans;
                    }
                });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
