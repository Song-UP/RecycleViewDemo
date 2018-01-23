package llapps.com.recycleviewdemo.been;

/**
 * Created by wusong on 2018/1/22.
 */

public class GoodDetail {
    private String title;

    private int iconId;
    private String name;
    private float price;

    private int isRight; //-1代表在左边，1代表在右边


    public GoodDetail(String title, int iconId, String name, float price) {
        this.title = title;
        this.iconId = iconId;
        this.name = name;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getIsRight() {
        return isRight;
    }

    public void setIsRight(int isRight) {
        this.isRight = isRight;
    }
}
