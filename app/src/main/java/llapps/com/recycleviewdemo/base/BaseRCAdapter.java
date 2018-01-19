package llapps.com.recycleviewdemo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wusong on 2018/1/16.
 * recycleview Adapter 基础类
 */

public abstract class BaseRCAdapter<T> extends RecyclerView.Adapter<BaseRCViewHold> {
    protected List<T> dataList;
    protected int converId;
    protected Context context;

    /**
     *
     * @param context
     * @param convertId
     * @param dataList
     * {@hide}
     */
    public BaseRCAdapter( Context context,  int convertId, List<T> dataList) {
        this.converId = convertId;
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public BaseRCViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseRCViewHold baseRCViewHold = BaseRCViewHold.get(context, converId, null);
        return baseRCViewHold;
    }

    @Override
    public void onBindViewHolder(BaseRCViewHold holder, int position) {
        onBindView(holder, dataList.get(position));

    }
    //接口用于外部调用，设置界面
    public abstract void onBindView(BaseRCViewHold holder, T data);

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
