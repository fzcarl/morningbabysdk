package com.morningbaby.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by carl on 15/8/2.
 */
public class KnowledgeImage {

    @JsonProperty("id")
    private String mId;

    @JsonProperty("location")
    private String mLocation;

    public KnowledgeImage(){

    }
    public KnowledgeImage(String id){
        mId = id;
    }
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }
}
