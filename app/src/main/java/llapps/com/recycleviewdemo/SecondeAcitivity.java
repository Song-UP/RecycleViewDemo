package llapps.com.recycleviewdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import llapps.com.recycleviewdemo.base.SpanRCAdapter;
import llapps.com.recycleviewdemo.base.rcAdapter.BaseRCAdapter;
import llapps.com.recycleviewdemo.base.rcAdapter.BaseRCViewHold;
import llapps.com.recycleviewdemo.base.rcAdapter.HeadMutiRCAdapter;
import llapps.com.recycleviewdemo.base.rcAdapter.MultiRCAdapter;
import llapps.com.recycleviewdemo.been.ImageText;
import llapps.com.recycleviewdemo.util.Constance;

/**
 * Created by wusong on 2018/1/23.
 */

public class SecondeAcitivity extends AppCompatActivity {

    public static  String[] adptetaNames = {"base","multi","headStr","span01"};
    public static String ADAPTER = "adpter";

    @BindView(R.id.recycleview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    public void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);
        String adName = getIntent().getStringExtra(ADAPTER);

        if(adptetaNames[0].equals(adName)){
            baseAdapter();
        }else if(adptetaNames[1].equals(adName)){
            multiAdapter();

        }else if(adptetaNames[2].equals(adName)){
            headStrAdapter();
        }else if(adptetaNames[3].equals(adName)){
            spanAdapter();

        }
    }
    public static void start(Context context, String adName){
        Intent intent = new Intent(context, SecondeAcitivity.class);
        intent.putExtra(ADAPTER, adName);
        context.startActivity(intent);
    }


//-------------------
    /**
     * 最基础的封装是用
     */
    public void baseAdapter(){
        List<Integer> dataList = new ArrayList<>();
        for (int i = 0; i<100; i++){
            dataList.add(Constance.img1_1s[i%Constance.img1_1s.length]);
        }
        BaseRCAdapter<Integer> baseRCAdapter = new BaseRCAdapter<Integer>(this, R.layout.item_image, dataList) {
            @Override
            public void onBindView(BaseRCViewHold holder, Integer data) {
                holder.setImageResource(R.id.image, data);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(baseRCAdapter);
    }

    //--------------------

    /**
     * 多种布局的封装是用
     */
    List<ImageText> imageTexts = new ArrayList<>();
    public void multiAdapter(){
        int num = 1;
        for(int i = 0; i<100; i++){
            int type = 1;
            String text = "图片";
            if (i == num){
                text = "这个位置是"+i+"个";
                type = 0;
                num += 5;
            }
            imageTexts.add(new ImageText(Constance.img1_1s[i%Constance.img1_1s.length], text, type ));
        }

        MultiRCAdapter.MultiItemTypeSupport<ImageText> multiItemTypeSupport = new
                MultiRCAdapter.MultiItemTypeSupport<ImageText>() {
                    @Override
                    public int getItemType(int position, ImageText data) {
                        return data.getType();
                    }
                    @Override
                    public int getItemView(int type) {
                        int viewId = 0;
                        switch (type){
                            case 0:
                                viewId = R.layout.item_text;
                                break;
                            case 1:
                                viewId = R.layout.item_image;
                                break;
                        }
                        return viewId;
                    }
                };
        MultiRCAdapter<ImageText> multiRCAdapter = new MultiRCAdapter<ImageText>(this, imageTexts , multiItemTypeSupport ) {
            @Override
            public void onBindView(BaseRCViewHold holder, ImageText data) {
                ImageText imageText = (ImageText) data;
                if ( multiItemTypeSupport.getItemType(0,data) == 0) {
                    holder.setText(R.id.text, imageText.getText());
                    holder.getContentView().setBackgroundResource(R.color.red01);
                }
                else
                    holder.setImageResource( R.id.image ,((ImageText) data).getIconId());

            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(multiRCAdapter);
    }

    //--------------------

    /**
     * 含有头部(字符串)的, 根据内容添加头部() 是用
     */

    public void headStrAdapter(){
        List<ImageText> dataList = new ArrayList<>();
        for (char ch = 'A'; ch<'Z'; ch++){
            // headList.add(ch+"");
            for (int i = 0; i< ( ch - 'A')*2; i++){
                dataList.add( new ImageText(  ch+"", 0, ch+""+i) );
            }
        }
        HeadMutiRCAdapter.HeadSupport<ImageText> headSupport = new HeadMutiRCAdapter.HeadSupport<ImageText>() {
            @Override
            public int headLayoutId() {
                return R.layout.item_text_gray;
            }

            @Override
            public int headTextViewId() {
                return R.id.text;
            }

            @Override
            public String getTitle(ImageText data) {
                return data.getTitle();
            }
        };

        HeadMutiRCAdapter<ImageText> headMutiRCAdapter = new HeadMutiRCAdapter<ImageText>
                (this, R.layout.item_text, dataList, headSupport) {
            @Override
            public void onBindView(BaseRCViewHold holder, Object data) {
                holder.setText(R.id.text, ((ImageText)data).getText());
            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(headMutiRCAdapter);

    }

    //-----------------------------
    /**
     * 不同列的显示
     */
    final int SPAN = 4;
    public void spanAdapter(){
        List<ImageText> dataList = new ArrayList<>();

        int num = 0;
        String imgUrl = "图片";
        for (int i = 0; i< 100; i++){
            imgUrl = "";//Constance.imageUrls[i % Constance.imageUrls.length];
            int type = 1;
            int Span = SPAN/2;
            String title = "图片";

            if (num  == i){
                num *= num ;
                title = "这是第"+num+"个标题";
                type = 0;
                Span = SPAN;
            }
            dataList.add(new ImageText( title, imgUrl, type, Span,
                    Constance.img1_1s[i%Constance.img1_1s.length]));

            if (num == 0){
                num =2;

            }

        }

        //决定 item 所占区域大小
        SpanRCAdapter.SpanSupport<ImageText> spanSupport = new SpanRCAdapter.SpanSupport<ImageText>() {
            @Override
            public int getSpan(int position, ImageText data) {
                return data.getSpan();
            }
        };
        //决定布局
        MultiRCAdapter.MultiItemTypeSupport<ImageText> multiItemTypeSupport =
                new MultiRCAdapter.MultiItemTypeSupport<ImageText>() {
                    @Override
                    public int getItemType(int position, ImageText data) {
                        return data.getType();
                    }

                    @Override
                    public int getItemView(int type) {

                        int viewId = 0;
                        switch (type){
                            case 0:
                                viewId = R.layout.item_text_gray;
                                break;
                            case 1:
                                viewId = R.layout.item_image;
                                break;
                        }
                        return viewId;
                    }
                };
        SpanRCAdapter<ImageText> spanRCAdapter = new SpanRCAdapter<ImageText>(this, dataList,
                multiItemTypeSupport, spanSupport) {
            @Override
            public void onBindView(BaseRCViewHold holder, ImageText data) {
                int type = data.getType();
                if (type == 0){
                    holder.setText(R.id.text, data.getTitle());
                }else {
                    //holder.setImageGlide(R.id.image, data.getImageUrl());
                    holder.setImageResource(R.id.image, data.getIconId());
                }

            }

        };
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(spanRCAdapter);

    }

}
