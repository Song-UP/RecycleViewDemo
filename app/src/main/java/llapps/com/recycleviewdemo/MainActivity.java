package llapps.com.recycleviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import llapps.com.recycleviewdemo.base.BaseRCAdapter;
import llapps.com.recycleviewdemo.base.BaseRCViewHold;
import llapps.com.recycleviewdemo.base.HeadMutiRCAdapter;
import llapps.com.recycleviewdemo.base.MultiRCAdapter;
import llapps.com.recycleviewdemo.been.ImageText;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        //baseAdapter();
        //multiAdapter();
        headAdapter();


    }

    public void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.recycleview);

    }

    /**
     * 最基础的封装
     */
    public void baseAdapter(){
        List<Integer> dataList = null;
        for (int i = 0; i<100; i++){
            dataList.add(R.mipmap.ic_launcher);
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

    /**
     * 多种布局的封装
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
                num *= 2;
            }
            imageTexts.add(new ImageText(R.mipmap.ic_launcher, text, type ));
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
            public void onBindView(BaseRCViewHold holder, Object data) {
                ImageText imageText = (ImageText) data;
                if ( multiItemTypeSupport.getItemType(0,data) == 0)
                    holder.setText( R.id.text ,imageText.getText());
                else
                    holder.setImageResource( R.id.image ,((ImageText) data).getIconId());

            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(multiRCAdapter);
    }

    /**
     * 含有头部的, 根据内容添加头部
     */

    public void headAdapter(){
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



}
