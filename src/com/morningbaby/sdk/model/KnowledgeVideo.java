package com.morningbaby.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by carl on 15/8/2.
 */
public class KnowledgeVideo {

    @JsonProperty("id")
    private String mId;

    @JsonProperty("title")
    private String mTitle;

    @JsonProperty("time")
    private String mTime;

    @JsonProperty("description")
    private String mDescription;

    @JsonProperty("thumbnail")
    private String mThumbnail;

    @JsonProperty("tags")
    private String mTags;

    @JsonProperty("topic_id")
    private String mTopicId;

    @JsonProperty("location")
    private String mLocation;

    public KnowledgeVideo() {
    }

    public KnowledgeVideo(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.mThumbnail = thumbnail;
    }

    public String getTags() {
        return mTags;
    }

    public void setTags(String tags) {
        this.mTags = tags;
    }

    public String getTopicId() {
        return mTopicId;
    }

    public void setTopicId(String topicId) {
        this.mTopicId = topicId;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        this.mLocation = location;
    }
    public String gettitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        this.mTitle = title;
    }
}
