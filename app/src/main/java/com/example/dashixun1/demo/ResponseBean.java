package com.example.dashixun1.demo;

import com.google.gson.JsonElement;

import java.io.Serializable;

/**
 * 项目名：Shopping
 * 包名：  com.example.liangxq.shopping.app
 * 文件名：Response
 * 创建者：liangxq
 * 创建时间：2020/8/1  14:58
 * 描述：TODO
 */
public class ResponseBean<T> implements Serializable{
    private JsonElement data;
    private int errorCode;
    private String errorMsg;

    public JsonElement getData() {
        return data;
    }

    public void setData(JsonElement data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
