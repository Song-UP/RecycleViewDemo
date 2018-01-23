package llapps.com.recycleviewdemo.been.banner;

/**
 * Created by wusong on 2018/1/22.
 */

public class BannerBeen {
    private int type;
    private String name;
    private int iconId;

    public BannerBeen(int type, String name, int iconId) {
        this.type = type;
        this.name = name;
        this.iconId = iconId;
    }

    public BannerBeen(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
