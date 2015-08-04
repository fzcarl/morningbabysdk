package com.morningbaby.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by carl on 15/8/2.
 */
public class KnowledgeArticle {
    @JsonProperty("id")
    private String mId;

    @JsonProperty("time")
    private String mTime;

    @JsonProperty("title")
    private String mTitle;

    @JsonProperty("author")
    private String mAuthor;

    @JsonProperty("tags")
    private String mTags;

    @JsonProperty("topic_id")
    private String mTopicId;

    public KnowledgeArticle() {
    }

    public KnowledgeArticle(String id) {
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getTime() {
        return mTime;
    }

    public void setTime(String time) {
        this.mTime = time;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
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
}
