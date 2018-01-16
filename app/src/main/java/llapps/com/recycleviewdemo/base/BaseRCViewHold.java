package llapps.com.recycleviewdemo.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wusong on 2018/1/16.
 *
 */

public class BaseRCViewHold extends RecyclerView.ViewHolder {
    SparseArray<View> viewSpare;
    View itemView;
    Context context;

    public static BaseRCViewHold get(Context context, View itemView){
        return new BaseRCViewHold(context, itemView);
    }

    public static BaseRCViewHold get(Context context, int itemId, ViewGroup viewGroup){
        View itemView = LayoutInflater.from(context).inflate(itemId, viewGroup,false);
        return new BaseRCViewHold(context, itemView);
    }

    public BaseRCViewHold(Context context, View itemView) {
        super(itemView);
        this.context = context;
        this.itemView = itemView;
        viewSpare = new SparseArray<>();
    }




    public View getContentView(){
        return this.itemView;
    }

    public <T extends  View> T getView(int viewId){
        View view = viewSpare.get(viewId);
        if (view == null){
            view = itemView.findViewById(viewId);
            viewSpare.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 点击事件监听
     * @param viewId
     * @param onClickListener
     * @return
     */

    public BaseRCViewHold setOnClickLister(int viewId , View.OnClickListener onClickListener){
        getView(viewId).setOnClickListener(onClickListener);
        return this;
    }

    /**
     * 图片
     */
    public BaseRCViewHold setImageResource(int viewId, int iconId){
        ImageView imageView = getView(viewId);
        imageView.setImageResource(iconId);
        return this;
    }

    /**
     * 文字
     */

    public BaseRCViewHold setText(int viewId, int strId){
        setText(viewId, context.getString(strId));
        return this;
    }
    public BaseRCViewHold setText(int viewId, String str){
        TextView textView = getView(viewId);
        textView.setText(str);
        return this;
    }








}
