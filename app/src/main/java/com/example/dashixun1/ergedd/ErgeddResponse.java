package com.example.dashixun1.ergedd;

import com.google.gson.JsonElement;

import java.util.List;

public class ErgeddResponse {

    /**
     * record : {"keywords":["小猪佩奇","汪汪队立大功"]}
     * status : 200
     * messages : {"succeed":[""]}
     */

    private JsonElement record;
    private int status;
    private JsonElement messages;

    public JsonElement getRecord() {
        return record;
    }

    public void setRecord(JsonElement record) {
        this.record = record;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public JsonElement getMessages() {
        return messages;
    }

    public void setMessages(JsonElement messages) {
        this.messages = messages;
    }

    public static class MessagesBean {
        private List<String> succeed;

        public List<String> getSucceed() {
            return succeed;
        }

        public void setSucceed(List<String> succeed) {
            this.succeed = succeed;
        }
    }
}
