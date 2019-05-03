package llapps.com.recycleviewdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import llapps.com.rcadaptepatting.base.rcAdapter.BaseRCAdapter;
import llapps.com.rcadaptepatting.base.rcAdapter.BaseRCViewHold;

/**
 * @Description：描述信息
 * @Author：Song UP
 * @Date：2019/5/3 13:03
 * 修改备注：
 */
public class SnapHelperActivity extends AppCompatActivity {
    private RecyclerView mRecycleview;
    private LinearLayout mMainActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        mRecycleview = (RecyclerView) findViewById(R.id.recycleview);
        mMainActivity = (LinearLayout) findViewById(R.id.activity_main);
        initRecyvleView();

    }

    public void initRecyvleView(){
        mRecycleview.setLayoutManager(new LinearLayoutManager(this));
        BaseRCAdapter<Integer> baseRCAdapter = new BaseRCAdapter<Integer>(this,R.layout.item_snaphelper,  getList()) {
            @Override
            public void onBindView(BaseRCViewHold holder, Integer data) {
                holder.setImageResource(R.id.image, data);
            }
        };

        mRecycleview.setAdapter(baseRCAdapter);
        //一次可以滑动多个页面
//        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
//        linearSnapHelper.attachToRecyclerView(mRecycleview);

        //一次只能滑动一个界面
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(mRecycleview);

    }

    List<Integer> list = new ArrayList<>();
    public List<Integer> getList(){
        for (int i =0;i<20;i++){
            list.add(R.drawable.im11_1);
        }

        return list;
    }



}
