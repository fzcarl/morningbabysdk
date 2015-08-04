package com.morningbaby.sdk;

import android.app.Application;
import com.morningbaby.sdk.model.User;
import com.nd.smartcan.frame.dao.GlobalHttpConfig;

/**
 * Created by carl on 15/8/2.
 */
public class SdkManager {
    private static SdkManager mInstance;
    private static String SDK_BASE_URL="BabyBaseUrl";
    private static int mTTL= 24*3600;
    private Application application;
    private User mUser=null;
    /**
     * 获得SdkManager实例
     *
     * @return SdkManager实例
     */
    public static SdkManager getInstance() {
        if (mInstance == null) {
            synchronized (SdkManager.class) {
                if (mInstance == null) {
                    mInstance = new SdkManager();
                }
            }
        }
        return mInstance;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * 设置访问的域名前缀
     * http://xxxx.com.cn/
     *
     * @param url
     */
    public void setBaseUrl(String url){
        GlobalHttpConfig.bindArgument(SDK_BASE_URL, url);
    }

    /**
     * 缓存的有效期
     * @return
     */
    public int getCacheTTL(){
        return mTTL;
    }

    /**
     * 取得当前登入的用户
     * @return
     */
    public User getCurrentUser(){
        if(mUser!=null){
            return mUser;
        }
        mUser =  User.getCurrentUser();
        return mUser;
    }
}
