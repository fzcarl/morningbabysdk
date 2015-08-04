package com.morningbaby.sdk.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.morningbaby.sdk.model.ReturnObject;
import com.morningbaby.sdk.model.Screening;
import com.nd.smartcan.frame.dao.CacheDao;
import com.nd.smartcan.frame.exception.DaoException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by carl on 15/8/3.
 */
public class ScreeningDao extends CacheDao<Screening> {

    private static final String BaseUrl = "${BabyBaseUrl}";

    public ScreeningDao(String id){
        super(id);
    }
    @Override
    public void setObjId(String id){
        super.setObjId(id);
    }

    @Override
    protected String getResourceUri() {
        return null;
    }

    public boolean submit(Map<String,Object> data){
        String url = BaseUrl+"/screening/palsy";
        try {
            ReturnObject obj = super.post(url,data,null,ReturnObject.class);
            return obj.success();
        } catch (DaoException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ScreeningStruct getScreening(){
        String url = BaseUrl+"/user/${id}/screening/palsy";
        Map<String,Object> param = new HashMap<String, Object>();
        param.put("id",getObjId());
        try {
            ScreeningStruct result = super.get(url,null,ScreeningStruct.class);
            return result;
        } catch (DaoException e) {
            e.printStackTrace();
            return null;
        }
    }

    public class ScreeningStruct{
        @JsonProperty("result")
        private String result;
        @JsonProperty("detail")
        private List<Map<String,Integer>> detail;
    }
}
