package com.qh.xzm.jdsort.presenter;

import com.qh.xzm.jdsort.bean.Result;
import com.qh.xzm.jdsort.bean.RightBeanOut;
import com.qh.xzm.jdsort.http.DataCall;
import com.qh.xzm.jdsort.http.NetWorkManger;
import com.qh.xzm.jdsort.http.RequestInterFace;

import java.util.List;

import io.reactivex.Observable;

public class RightPresenter extends BasePresenter {


    public RightPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Observable observable(Object... args) {
        RequestInterFace requestInterFace = NetWorkManger.getInstance().create(RequestInterFace.class);
        Observable<Result<List<RightBeanOut>>> rightData = requestInterFace.rightData((int) args[0]);
        return rightData;
    }
}
