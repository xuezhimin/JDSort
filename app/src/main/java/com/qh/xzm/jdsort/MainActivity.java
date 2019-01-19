package com.qh.xzm.jdsort;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.qh.xzm.jdsort.adapter.LeftAdapter;
import com.qh.xzm.jdsort.adapter.RightAdapter;
import com.qh.xzm.jdsort.bean.LeftBean;
import com.qh.xzm.jdsort.bean.Result;
import com.qh.xzm.jdsort.bean.RightBeanOut;
import com.qh.xzm.jdsort.http.DataCall;
import com.qh.xzm.jdsort.presenter.LeftPresenter;
import com.qh.xzm.jdsort.presenter.RightPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mLeftRvView;
    private RecyclerView mRightRvView;
    private LeftPresenter leftPresenter = new LeftPresenter(new LeftDataCall());
    private RightPresenter rightPresenter = new RightPresenter(new RightDataCall());
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    //    private int cid = 1;
    private List<LeftBean> leftBeanList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        leftAdapter = new LeftAdapter(getBaseContext());
        rightAdapter = new RightAdapter(getBaseContext());
        //请求数据
        leftPresenter.request();
        rightPresenter.request(1);
        mLeftRvView.setAdapter(leftAdapter);
        mRightRvView.setAdapter(rightAdapter);
        //线性布局管理器
        mLeftRvView.setLayoutManager
                (new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //调用系统自带分割线
        mLeftRvView.addItemDecoration
                (new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //线性布局管理器
        mRightRvView.setLayoutManager
                (new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //调用系统自带分割线
        mRightRvView.addItemDecoration
                (new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void initView() {
        mLeftRvView = findViewById(R.id.left_rv_view);
        mRightRvView = findViewById(R.id.right_rv_view);
    }


    /**
     * 内部类获取左侧数据方法
     */
    class LeftDataCall implements DataCall<Result<List<LeftBean>>> {

        @Override
        public void success(Result<List<LeftBean>> data) {
            if (data.getCode().equals("0")) {
                leftBeanList = data.getData();
                leftAdapter.addAll(leftBeanList);
                leftAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(getBaseContext(), data.getMsg() + "", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void fail(Throwable e) {
            Toast.makeText(getBaseContext(), e + "", Toast.LENGTH_SHORT).show();
        }
    }

    class RightDataCall implements DataCall<Result<List<RightBeanOut>>> {

        @Override
        public void success(Result<List<RightBeanOut>> data) {
            if (data.getCode().equals("0")) {
                List<RightBeanOut> rightBeanOutList = data.getData();
                rightAdapter.clear();
                rightAdapter.addAll(rightBeanOutList);
                rightAdapter.notifyDataSetChanged();
                //实现左右联动
                leftAdapter.setLeftCheckListener(new LeftAdapter.LeftCheckListener() {
                    @Override
                    public void onItemClick(int position) {
                        for (int i = 0; i < leftBeanList.size(); i++) {
                            //默认选中第一个
                            leftBeanList.get(i).setClick(true);
                            //获取每次点击的 cid
                            int cid = leftBeanList.get(position).getCid();
                            //每次点击获取cid 传给相应的接口相应
                            rightPresenter.request(cid);
                        }
                        //刷新适配器
                        rightAdapter.notifyDataSetChanged();
                    }
                });
            } else {
                Toast.makeText(getBaseContext(), data.getMsg() + "", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void fail(Throwable e) {
            Toast.makeText(getBaseContext(), e + "", Toast.LENGTH_SHORT).show();
        }
    }

    //防止内存泄露
    @Override
    protected void onDestroy() {
        super.onDestroy();
        leftPresenter.unBind();
        rightPresenter.unBind();
    }

}
