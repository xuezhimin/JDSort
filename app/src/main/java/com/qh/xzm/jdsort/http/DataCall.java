package com.qh.xzm.jdsort.http;

public interface DataCall<T> {


    void success(T data);

    void fail(Throwable e);


}
