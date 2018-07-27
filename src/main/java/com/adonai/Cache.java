package com.adonai;

public class Cache {

    /**
     * key
     */
    private String key;
    /**
     * 缓存数据
     */
    private Object value;
    /**
     * 超时时间
     */
    private Long timeOut;

    public Cache(String key, Object value, Long timeOut) {
        super();
        this.key = key;
        this.value = value;
        this.timeOut = timeOut;
    }

    public Cache() {

    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }

    public Object getValue() {

        return value;
    }

    public void setValue(Object value) {

        this.value = value;
    }

    public Long getTimeOut() {

        return timeOut;
    }

    public void setTimeOut(Long timeOut) {

        this.timeOut = timeOut;
    }

}
