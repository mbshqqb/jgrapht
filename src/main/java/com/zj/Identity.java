package com.zj;

import java.io.Serializable;
//必须重写equals方法和hashCode方法
public class Identity implements Serializable{
    String uid;
    public Identity(String uid){
        this.uid=uid;
    }

    public String getUid() {
        return uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identity)) return false;

        Identity identity = (Identity) o;

        return getUid() != null ? getUid().equals(identity.getUid()) : identity.getUid() == null;
    }

    @Override
    public int hashCode() {
        return getUid() != null ? getUid().hashCode() : 0;
    }
}
