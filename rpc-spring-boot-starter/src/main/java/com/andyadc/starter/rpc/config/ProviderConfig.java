package com.andyadc.starter.rpc.config;

public class ProviderConfig {

    protected String clazz; // 接口
    protected String ref;    // 映射
    protected String alias;  // 别名

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
