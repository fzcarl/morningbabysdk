package com.morningbaby.sdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by carl on 15/8/2.
 */
public class Hospital {

    @JsonProperty("id")
    private String mId;

    @JsonProperty("name")
    private String mName;

    @JsonProperty("phone")
    private String mPhone;

    @JsonProperty("address_province")
    private String mAddressProvince;

    @JsonProperty("address_city")
    private String mAddressCity;

    @JsonProperty("address_distinct")
    private String mAddressDistinct;

    @JsonProperty("address_detail")
    private String mAddressDetail;

    @JsonProperty("address_geo")
    private String mAddressGeo;

    @JsonProperty("introduction")
    private String mIntroduction;

    /**
     * 获取id
     *
     * @return id
     */
    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getAddressProvince() {
        return mAddressProvince;
    }

    public void setAddressProvince(String mAddressProvince) {
        this.mAddressProvince = mAddressProvince;
    }

    public String getAddressCity() {
        return mAddressCity;
    }

    public void setAddressCity(String mAddressCity) {
        this.mAddressCity = mAddressCity;
    }

    public String getAddressDistinct() {
        return mAddressDistinct;
    }

    public void setAddressDistinct(String mAddressDistinct) {
        this.mAddressDistinct = mAddressDistinct;
    }

    public String getAddressDetail() {
        return mAddressDetail;
    }

    public void setAddressDetail(String mAddressDetail) {
        this.mAddressDetail = mAddressDetail;
    }

    public String getAddressGeo() {
        return mAddressGeo;
    }

    public void setAddressGeo(String mAddressGeo) {
        this.mAddressGeo = mAddressGeo;
    }

    public String getIntroduction() {
        return mIntroduction;
    }

    public void setIntroduction(String mIntroduction) {
        this.mIntroduction = mIntroduction;
    }
}
