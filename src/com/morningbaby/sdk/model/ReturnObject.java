package com.morningbaby.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Created by carl on 15/8/3.
 */
public class ReturnObject {

    @JsonProperty("result")
    private String result;

    @JsonProperty("detail")
    private Map<String,Object> detail;

    @JsonProperty("msg")
    private String msg;

    public ReturnObject(){
    }
    public ReturnObject(boolean flag){
        if(flag){
            result ="success";
        }
        else{
            result = "failed";
        }
    }

    public boolean success(){
        return "success".equalsIgnoreCase(result);
    }
    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Map<String,Object> getDetail() {
        return detail;
    }

    /*
    public void setDetail(String detail) {
        this.detail = detail;
    }
    */

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
