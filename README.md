# RecycleViewDemo

1. Adapter简单封装
封装后的使用
BaseRCAdapter<Integer> baseRCAdapter = new BaseRCAdapter<Integer>(this, R.layout.item_image, dataList) {
            @Override
            public void onBindView(BaseRCViewHold holder, Integer data) {
                holder.setImageResource(R.id.image, data);
            }
        };
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(baseRCAdapter);
 效果如下
 <img src="https://github.com/Song-UP/ImageStore/blob/master/Image/RecycleViewAdapter/baseRcAdapter.png?raw=true" width="280" height="475" />
 
 2.Adapter多布局的封装使用
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
                if ( multiItemTypeSupport.getItemType(0,data) == 0)
                    holder.setText( R.id.text ,imageText.getText());
                else
                    holder.setImageResource( R.id.image ,((ImageText) data).getIconId());

            }
        };
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        recyclerView.setAdapter(multiRCAdapter);
        
效果图如下
        <img src="https://github.com/Song-UP/ImageStore/blob/master/Image/RecycleViewAdapter/baseRcMulti.png?raw=true" width="280" height="475" />
        
 3. 根据数据添加头部的封装
 
 代码有点多，只看效果吧
  <img src="https://github.com/Song-UP/ImageStore/blob/master/Image/RecycleViewAdapter/baseRcHead.png?raw=true" width="280" height="475" />
 
 https://github.com/Song-UP/ImageStore/blob/master/Image/RecycleViewAdapter/baseRcSpan.png?raw=true
 4. 不同列的封装
 效果图如下
 <img src="https://github.com/Song-UP/ImageStore/blob/master/Image/RecycleViewAdapter/baseRcSpan.png?raw=true" width="280" height="475" />
