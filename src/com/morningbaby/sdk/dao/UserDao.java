package com.morningbaby.sdk.dao;

import com.morningbaby.sdk.SdkManager;
import com.morningbaby.sdk.model.ReturnObject;
import com.morningbaby.sdk.model.User;
import com.nd.smartcan.frame.dao.CacheDao;
import com.nd.smartcan.frame.exception.DaoException;
import com.nd.smartcan.frame.model.DataSourceDefine;
import com.nd.smartcan.frame.dao.CacheDefine.IDataRetrieveListener;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户数据访问
 * Created by carl on 2015/08/02.
 */
public final class UserDao extends CacheDao<User> {
    private static final String BaseUrl = "${BabyBaseUrl}";

    public UserDao() {
    }

    @Override
    protected DataSourceDefine getDefaultListDefine() {
        return super.getDefaultListDefine()
                .withApi(BaseUrl+"/users?$key=${key}&$offset=${__start}&$limit=${__count}")
                //.withKeyField(UCClientConst.ORGANIZATION_CONST.USER_ID)
                //.withSortField(UCClientConst.ORGANIZATION_CONST.USER_ID)
                .withExpire(SdkManager.getInstance().getCacheTTL());
    }

    @Override
    protected DataSourceDefine getDefaultDetailDefine() {
        return super.getDefaultDetailDefine().withApi(BaseUrl+"/user/${id}")
                .withExpire(SdkManager.getInstance().getCacheTTL());
    }

    /**
     * 取得Post Uri
     * http://www.nd.com/k12app/class/${class}/student/
     * http://www.nd.com/k12app/class/
     */
    @Override
    protected String getResourceUri() {
        return BaseUrl;
    }

    /**
     * 异步取得用户资料
     * @param uid
     * @param listener
     * @param force
     */
    public void getAsync(String uid,IDataRetrieveListener listener,boolean force){
        Map<String, Object> stringMap = new HashMap<String, Object>();
        stringMap.put("id", uid);
        super.get(listener,stringMap,force);
    }
    /**
     * //@see com.nd.smartcan.accountclient.dao.UserDao#get(long, String)
     */
    public User get(String uid ) throws DaoException {
        Map<String, Object> stringMap = new HashMap<String, Object>();
        stringMap.put("id", uid);
        return super.get(stringMap);
    }

    public ReturnObject login(String account,String pwd){
        String url = BaseUrl+"/user/${account}/session";
        Map<String,String> data = new HashMap<String, String>();
        data.put("password",pwd);
        //todo getDeviceId
        data.put("device_id","deviceid");
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("account",account);
        try {
            ReturnObject ret = super.post(url, data, param, ReturnObject.class);
            return ret;
        }
        catch (DaoException e){
            e.printStackTrace();
            return new ReturnObject(false);
        }
    }


    public void logout(String account,String session){
        String url = BaseUrl+"/user/${account}/session/${session}";
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("account",account);
        param.put("session",session);
        try {
            ReturnObject ret = super.post(url, null, param, ReturnObject.class);
        }
        catch (DaoException e){
            e.printStackTrace();
        }
        // logout event
    }
    public ReturnObject register(String phone,String email,String pwd){
        String  url = getResourceUri();
        Map<String,String> data = new HashMap<String, String>();
        data.put("email",email);
        data.put("phone",phone);
        data.put("password",pwd);
        try{
            ReturnObject ret = super.post(url, data, null, ReturnObject.class);
            return ret;
        }
        catch (DaoException e){
            e.printStackTrace();
            return new ReturnObject(false);
        }
    }
    public boolean update(User user){
        String url = getResourceUri()+"/"+user.getUid();
        try {
            ReturnObject ret = super.post(user,null,ReturnObject.class);
            return ret.success();
        } catch (DaoException e) {
            e.printStackTrace();
            return false;
        }


    }
}

