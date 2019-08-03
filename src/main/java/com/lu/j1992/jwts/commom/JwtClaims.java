package com.lu.j1992.jwts.commom;

import java.util.HashMap;
import java.util.Objects;

/**
 * 用来存储我们需要保存到JWT中的数据表
 * Created by Administrator on 2019/7/28.
 */
public class JwtClaims extends HashMap {

    public JwtClaims(){
        this.put(ID,null);
        this.put(NAME,null);
        this.put(PHONE,null);
        this.put(FAILURETIME,null);
    }

    String ID = "id";
    String NAME = "name";
    String PHONE = "phone";
    /**
     * 有效期
     */
    String FAILURETIME = "failureTime";

    public JwtClaims put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * 重写hashcode方法
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this);
    }

}
