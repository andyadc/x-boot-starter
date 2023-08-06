package com.andyadc.starter.rpc.config;

public class ConsumerConfig {

    protected String clazz; // 接口
    protected String alias;  // 别名

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
