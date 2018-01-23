package llapps.com.recycleviewdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import llapps.com.recycleviewdemo.adapter.BannerDecoraRCAdapter;
import llapps.com.recycleviewdemo.adapter.BannerSpanRCAdapter;
import llapps.com.recycleviewdemo.base.rcAdapter.BaseRCViewHold;
import llapps.com.recycleviewdemo.been.GoodDetail;
import llapps.com.recycleviewdemo.been.SpaceDecoration;
import llapps.com.recycleviewdemo.been.banner.BannerBeen;
import llapps.com.recycleviewdemo.been.banner.GlideImageLoader;
import llapps.com.recycleviewdemo.util.Constance;

/**
 * Created by wusong on 2018/1/23.
 */

public class BannerAcitivty extends AppCompatActivity {

    public static  String[] adptetaNames = {"bannerHeadStr","bannerDecor"};
    public static String ADAPTER = "adpter";
    @BindView(R.id.recycleview)
    RecyclerView recyclerView;
    List<BannerBeen> bannerList;
    List<GoodDetail> goodDetailList;

    public static void start(Context context, String adName){
        Intent intent = new Intent(context, BannerAcitivty.class);
        intent.putExtra(ADAPTER, adName);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);

        initData();
        String adName = getIntent().getStringExtra(ADAPTER);
        if(adptetaNames[0].equals(adName)){

            bannerSpan();
        }else if(adptetaNames[1].equals(adName)){
            //multiAdapter();
            setBannerDecode();

        }



    }
//带有Banner的recycleView
    public void bannerSpan(){
        //recycleView
        BannerSpanRCAdapter.BannerSupport<GoodDetail, String> bannerSupport = new BannerSpanRCAdapter.BannerSupport<GoodDetail, String>() {
            @Override
            public String getTitle(GoodDetail goodDetail) {
                return goodDetail.getTitle();
            }
        };
//不需要设置item靠边时用这个
         BannerSpanRCAdapter<GoodDetail, String> bannerSpanRCAdapter = new BannerSpanRCAdapter<GoodDetail, String>(this, goodDetailList, bannerSupport) {
            @Override
            public void onBindBanner(BaseRCViewHold holder) {
                Banner banner = (Banner) holder.getContentView();
                setBanner(banner);
            }

            @Override
            public void onBindTitle(BaseRCViewHold holder, String tileData) {
                holder.setText(R.id.tv_title, tileData);
            }

            @Override
            public void onBindDetail(BaseRCViewHold holder, GoodDetail data) {
                holder.setImageResource(R.id.iv_goods,data.getIconId());
                holder.setText(R.id.tv_name,data.getName());
            }
        };

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(bannerSpanRCAdapter);
    }


    public void initData(){
        int iconId = R.drawable.img3_1;
        String name = "秦时明月汉时关，万里长征人未还。待到重阳日，还来就菊花。";
        float price = 140;
        String[] tiltes = {"这动画画面不错","这动漫真好看","怎么还没有更新"};
        goodDetailList = new ArrayList<>();
        for (int i = 0; i<5; i++){
            String title02 = tiltes[i%tiltes.length];
            for (int j = 0; j<10; j++){
                iconId = Constance.img1_1s[j%Constance.img1_1s.length];
                goodDetailList.add(new GoodDetail(title02, iconId, name+j, price));
            }
        }
        bannerList = new ArrayList<>();
        bannerList.add(new BannerBeen(0,"文字", R.drawable.img1_13));
        bannerList.add(new BannerBeen(0,"文字", R.drawable.img2_13));
        bannerList.add(new BannerBeen(0,"文字", R.drawable.img3_13));
    }

    public void setBanner(Banner banner){
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setDelayTime(5000);

        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader(bannerList));
        //设置图片集合
        banner.setImages(bannerList);
        //设置banner动画效果
        //banner.setBannerAnimation(Transformer.ZoomIn);
        //设置标题集合（当banner样式有显示title时）
        //banner.setBannerTitles(bannerList);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
//                switch (i){
//                    case 0:
//                        //CardActivity.startActivity(context, "称谓和名字");
//                        Intent intent = new Intent(context, YudetailActivity.class);
//                        intent.putExtra("yemianID",1);
//                        context.startActivity(intent);
//                        break;
//                    case 1:
//                        CardActivity.startActivity(context, "食物*植物");
//                        break;
//                    case 2:
//                        CardActivity.startActivity(context, "旅游交通");
//                        break;
//                }

                Constance.showToast(BannerAcitivty.this);


            }
        });
    }

    //------------------
    //带有分割的RecycleView封装的是用
    public void setBannerDecode(){
        BannerSpanRCAdapter.BannerSupport<GoodDetail, String> bannerSupport = new BannerSpanRCAdapter.BannerSupport<GoodDetail, String>() {
            @Override
            public String getTitle(GoodDetail goodDetail) {
                return goodDetail.getTitle();
            }
        };
        //设置是在左边还是右边
        final BannerDecoraRCAdapter<GoodDetail, String> bannerSpanRCAdapter = new BannerDecoraRCAdapter<GoodDetail, String>(this, goodDetailList, bannerSupport) {
            @Override
            public void onBindBanner(BaseRCViewHold holder) {
                Banner banner = (Banner) holder.getContentView();
                setBanner(banner);
            }

            @Override
            public void onBindTitle(BaseRCViewHold holder, String tileData) {
                holder.setText(R.id.tv_title, tileData);
            }

            @Override
            public void onBindDetail(BaseRCViewHold holder, GoodDetail data) {
                //holder.setImageResource(R.id.iv_goods,data.getIconId());
                holder.setImageResource(R.id.iv_goods, data.getIconId());
                holder.setText(R.id.tv_name,data.getName());
            }
            //用来设置是左边还是右边，可以不用
            @Override
            public void setIsLeft(GoodDetail data, int right) {
                super.setIsLeft(data, right);
                data.setIsRight(right);
            }
        };
        recyclerView.addItemDecoration(new SpaceDecoration(this, 5) {
            @Override
            public int isItemLeft(long positon) {
                int type = bannerSpanRCAdapter.getItemViewType((int) positon);
                int isRight = 0;
                if (type == 2){ //如果是detail
                    int realPos = bannerSpanRCAdapter.getOtherPostion((int) positon);
                    if (realPos <0){
                        return 0;
                    }
                    isRight = goodDetailList.get(realPos).getIsRight();
                }
                return isRight;

            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(bannerSpanRCAdapter);

    }


}
