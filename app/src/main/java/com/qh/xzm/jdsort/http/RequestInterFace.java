package com.qh.xzm.jdsort.http;

import com.qh.xzm.jdsort.bean.LeftBean;
import com.qh.xzm.jdsort.bean.Result;
import com.qh.xzm.jdsort.bean.RightBeanOut;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterFace {

    //首页三种类型数据
    @GET("product/getCatagory")
    Observable<Result<List<LeftBean>>> LeftData();

    //关键字搜索
    @GET("product/getProductCatagory")
    Observable<Result<List<RightBeanOut>>> rightData(
            @Query("cid") int cid);
}
