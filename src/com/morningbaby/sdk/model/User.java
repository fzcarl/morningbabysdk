package com.morningbaby.sdk.model;

/**
 * Created by carl on 15/8/2.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.fasterxml.jackson.annotation.*;
import com.morningbaby.sdk.SdkManager;
import com.morningbaby.sdk.dao.UserDao;
//import com.nd.smartcan.accountclient.dao.UCDaoFactory;
import com.nd.smartcan.commons.util.logger.Logger;
import com.nd.smartcan.core.restful.ClientResourceUtils;
import com.nd.smartcan.core.restful.ResourceException;
import com.nd.smartcan.frame.exception.DaoException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户实体类
 * Created by wanghl on 2014/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class User implements Serializable {

    private final static String KEY_PREF_UID = "uid";
    private final static String KEY_PREF_SESSION = "session_id";

    private  String mUid;
    private  String mSession;

    private UserDao mDao=null;

    @JsonProperty("nick")
    private String mNick;

    @JsonProperty("email")
    private String mEmail;

    @JsonProperty("gender")
    private String mGender;

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

    @JsonProperty("baby_name")
    private String mBabyName;

    @JsonProperty("baby_born_pdd")
    private String mBabyBornPdd;

    @JsonProperty("baby_born_week")
    private String mBabyBornWeek;

    @JsonProperty("baby_gender")
    private String mBabyGender;

    @JsonProperty("baby_premature_reason")
    private String mBabyPrematureReason;

    @JsonProperty("baby_born_weight")
    private String mBabyBornWeight;

    @JsonProperty("baby_born_length")
    private String mBabyBornLength;

    @JsonProperty("baby_born_head")
    private String mBabyBornHead;

    @JsonProperty("baby_born_date")
    private String mBabyBornDate;

    @JsonProperty("baby_born_hospital")
    private String mBabyBornHospital;

    @JsonProperty("baby_apgar_score")
    private String mBabyApgarScore;

    public User() {
    }

    public User(String uid) {
        mUid = uid;
    }

    /**
     * 取得当前登入的用户
     * @return
     */
    public static User getCurrentUser(){
        User usr = new User();
        usr.loadCurrentUser();
        return usr;
    }

    /**
     * 获取用户uid
     *
     * @return 用户uid
     */
    public String getUid() {
        return mUid;
    }

    public void setUid(String uid) {
        mUid = uid;
    }

    /**
     * 获取用户昵称
     */
    public String getNick() {
        return mNick;
    }

    /**
     * 设置用户昵称
     */
    public void setNick(String nickName) {
        mNick= nickName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String gender) {
        this.mGender = gender;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        this.mPhone = phone;
    }

    public String getAddressProvince() {
        return mAddressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.mAddressProvince = addressProvince;
    }

    public String getAddressCity() {
        return mAddressCity;
    }

    public void setAddressCity(String addressCity) {
        this.mAddressCity = addressCity;
    }

    public String getAddressDistinct() {
        return mAddressDistinct;
    }

    public void setAddressDistinct(String addressDistinct) {
        this.mAddressDistinct = addressDistinct;
    }

    public String getAddressDetail() {
        return mAddressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.mAddressDetail = addressDetail;
    }

    public String getBabyName() {
        return mBabyName;
    }

    public void setBabyName(String babyName) {
        this.mBabyName = babyName;
    }

    public String getBabyBornPdd() {
        return mBabyBornPdd;
    }

    public void setBabyBornPdd(String babyBornPdd) {
        this.mBabyBornPdd = babyBornPdd;
    }

    public String getBabyBornWeek() {
        return mBabyBornWeek;
    }

    public void setBabyBornWeek(String babyBornWeek) {
        this.mBabyBornWeek = babyBornWeek;
    }

    public String getBabyGender() {
        return mBabyGender;
    }

    public void setBabyGender(String babyGender) {
        this.mBabyGender = babyGender;
    }

    public String getBabyPrematureReason() {
        return mBabyPrematureReason;
    }

    public void setBabyPrematureReason(String babyPrematureReason) {
        this.mBabyPrematureReason = babyPrematureReason;
    }

    public String getBabyBornWeight() {
        return mBabyBornWeight;
    }

    public void setBabyBornWeight(String babyBornWeight) {
        this.mBabyBornWeight = babyBornWeight;
    }

    public String getBabyBornLength() {
        return mBabyBornLength;
    }

    public void setBabyBornLength(String babyBornLength) {
        this.mBabyBornLength = babyBornLength;
    }

    public String getBabyBornHead() {
        return mBabyBornHead;
    }

    public void setBabyBornHead(String babyBornHead) {
        this.mBabyBornHead = babyBornHead;
    }

    public String getBabyBornDate() {
        return mBabyBornDate;
    }

    public void setBabyBornDate(String babyBornDate) {
        this.mBabyBornDate = babyBornDate;
    }

    public String getBabyBornHospital() {
        return mBabyBornHospital;
    }

    public void setBabyBornHospital(String babyBornHospital) {
        this.mBabyBornHospital = babyBornHospital;
    }

    public String getBabyApgarScore() {
        return mBabyApgarScore;
    }

    public void setBabyApgarScore(String babyApgarScore) {
        this.mBabyApgarScore = babyApgarScore;
    }
    private synchronized UserDao getDao(){
        if(mDao==null){
            mDao = new UserDao();
        }
        return mDao;
    }
    /**
     * 登入
     * @param account  email/mobile phone
     * @param pwd
     * @return
     */
    public ReturnObject login(String account,String pwd){
        ReturnObject ret = getDao().login(account, pwd);
        if(ret.success()){
            saveAccount(ret);
        }
        return ret;
    }
    public boolean logout(){
        getDao().logout(mUid, mSession);
        return true;
    }
    public ReturnObject register(String phone,String email,String pwd){
        return getDao().register(phone, email, pwd);
    }
    private void saveAccount(ReturnObject ret){
        Map<String,Object> data = ret.getDetail();
        SharedPreferences sp = SdkManager.getInstance().getApplication().getSharedPreferences("User", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(KEY_PREF_UID,(String)data.get("uid"));
        editor.putString(KEY_PREF_SESSION,(String)data.get("session_id"));
        editor.commit();
        loadCurrentUser();
    }

    /**
     * 保存用户资料
     * @return
     */
    public boolean saveUpdate(){
        try {
            ReturnObject ret = getDao().post(this,null,ReturnObject.class);
            return ret.success();
        } catch (DaoException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void loadCurrentUser(){
        SharedPreferences sp = SdkManager.getInstance().getApplication().getSharedPreferences("User", Context.MODE_PRIVATE);
        mUid = sp.getString(KEY_PREF_UID,"");
        mSession = sp.getString(KEY_PREF_SESSION,"");
    }
    public boolean isLogin(){
        return !TextUtils.isEmpty(mUid);
    }

    public boolean testReturnObj(){
        String str = "{\n" +
                "\t\t\"result\":\"success\",\n" +
                "\t\t\"detail\":{\n" +
                "\t\t\"uid\" : \"user id\",\n" +
                "\t\t\"session_id\": \"login session id\"\n" +
                "\t\t}\n" +
                "    }";
        ReturnObject obj = null;
        try {
            obj = ClientResourceUtils.stringToObj(str, ReturnObject.class);
            Map<String,Object> res = obj.getDetail();

            Logger.i(getClass(), "uid="+res.get("uid"));
            Logger.i(getClass(), "sessionid"+res.get("session_id"));
        } catch (ResourceException e) {
            e.printStackTrace();
        }
        return true;
    }
}
