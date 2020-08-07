package com.example.httplibrary2;

import com.google.gson.JsonElement;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface ApiServer {
    @GET
    Observable<JsonElement> get(@Url String url, @QueryMap Map<String,Object> params, @HeaderMap Map<String,Object> heards);
    @POST
    @FormUrlEncoded
    Observable<JsonElement> post(@Url String url, @FieldMap Map<String,Object> params,@HeaderMap Map<String,Object> heards);
    @POST
    Observable<JsonElement> positionBean(@Url String url, RequestBody requestBody,@HeaderMap Map<String,Object> heards);

}


