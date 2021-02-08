package com.cn.future.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author csx
 * @Date 2/8/21 11:08 AM
 * @Description TODO
 */
@Getter
@Setter
public class JsonVo<T> {

    private String flag;

    private String msg;

    private T obj;

    public JsonVo() {
    }

    public JsonVo(String flag, String msg, T obj) {
        this.flag = flag;
        this.msg = msg;
        this.obj = obj;
    }
}
