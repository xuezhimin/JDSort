package com.qh.xzm.jdsort.presenter;

import com.qh.xzm.jdsort.bean.LeftBean;
import com.qh.xzm.jdsort.bean.Result;
import com.qh.xzm.jdsort.http.DataCall;
import com.qh.xzm.jdsort.http.NetWorkManger;
import com.qh.xzm.jdsort.http.RequestInterFace;

import java.util.List;

import io.reactivex.Observable;

public class LeftPresenter extends BasePresenter {


    public LeftPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        RequestInterFace requestInterFace = NetWorkManger.getInstance().create(RequestInterFace.class);
        Observable<Result<List<LeftBean>>> leftData = requestInterFace.LeftData();
        return leftData;
    }
}
