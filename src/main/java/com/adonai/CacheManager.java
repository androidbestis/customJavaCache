package com.adonai;


import java.util.HashMap;
import java.util.Map;

/**
 * @classDesc: 功能描述:(缓存map)
 * @author: adonai
 * @createTime: 2018/7/27
 * @version: v1.0
 */
public class CacheManager {

  private Map<String,Cache>  cacheMap = new HashMap<String, Cache>();


  public void put(String key,Object obj){
    put(key,obj,null);
  }

    /**
     * 往Map中添加值
     * @param key
     * @param obj
     * @param timeOut
     */
  public synchronized void put(String key,Object obj,Long timeOut){
      //判断value是否为空
     if(obj == null){
         return;
     }
     Cache cache = new Cache();
     cache.setKey(key);
     if(timeOut != null)
         cache.setTimeOut(timeOut + System.currentTimeMillis());
     cache.setValue(obj);
     cacheMap.put(key,cache);
  }

    /**
     * 删除值
     */
  public synchronized void delete(String key){
     cacheMap.remove(key);
  }

    /**
     * 获取值
     */
  public synchronized Object get(String key){
      Cache cache = cacheMap.get(key);
      Object obj = null;
      if(cache != null){
          obj = cache.getValue();
      }
     return obj;
  }

    /**
     * 检查数据是否在<有效期>内
     */
  public void checkValidityData(){
    for(String key : cacheMap.keySet()){
        Cache cache = cacheMap.get(key);
        Long timeOut = cache.getTimeOut();
        if(timeOut == null){
            return;
        }
        long currrentTime = System.currentTimeMillis();
        long endTime = timeOut;
        long result = (currrentTime - endTime);
        if(result > 0){
            cacheMap.remove(key);
        }
    }

  }



}
