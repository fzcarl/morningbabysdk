package com.morningbaby.sdk.model;

import com.morningbaby.sdk.dao.ScreeningDao;

import java.util.*;

/**
 * Created by carl on 15/8/3.
 */
public class Screening {

    private String uid;
    private boolean result=true;
    private Map<Integer,Integer> screening=new HashMap<Integer, Integer>();

    private ScreeningDao mDao=null;

    public Screening(String uid){
        this.uid = uid;
    }
    public void setResult(boolean flag){
        this.result = flag;
    }
    public boolean getResult(){
        return this.result ;
    }
    public void setScreening(int seq, int choice){
        this.screening.put(seq,choice);
    }

    /**
     * 0 代表未选择
     *
     * @param seq
     * @return
     */
    public int getScreening(int seq){
        Integer res = this.screening.get(seq);
        if(res==null){
            return 0;
        }
        return res.intValue();
    }

    private synchronized ScreeningDao getDao(){
        if(mDao==null){
            mDao = new ScreeningDao(this.uid);
        }
        return mDao;
    }

    public boolean post(){
        Map<String,Object> data = new HashMap<String, Object>();
        Set<Integer> set = this.screening.keySet();
        Iterator<Integer> it = set.iterator();
        List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
        while(it.hasNext()){
            Map<String,Integer> item = new HashMap<String, Integer>();
            int key = it.next().intValue();
            item.put("question",key);
            item.put("choice",this.screening.get(key));
            list.add(item);
        }
        data.put("uid",this.uid);
        data.put("result",this.result);
        data.put("detail",list);
        return getDao().submit(data);
    }
    public void loadScreening(){

    }
}
