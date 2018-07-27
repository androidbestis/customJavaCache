package com.adonai;

public class TestMain {

    public static void main(String[] args) throws InterruptedException {
       CacheManager cacheManager = new CacheManager();
       //cacheManager.put("lisi", "你好");
       cacheManager.put("zhansan","jjj",5000l);
       Thread.sleep(5000);
       cacheManager.checkValidityData();
       System.out.println(cacheManager.get("zhansan"));
    }

}
