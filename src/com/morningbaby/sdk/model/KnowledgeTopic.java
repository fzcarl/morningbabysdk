package com.morningbaby.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by carl on 15/8/2.
 */
public class KnowledgeTopic {

    @JsonProperty("id")
    private String mId;

    @JsonProperty("name")
    private String mName;

    @JsonProperty("description")
    private String mDescription;

    public KnowledgeTopic(){

    }

    public KnowledgeTopic(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
