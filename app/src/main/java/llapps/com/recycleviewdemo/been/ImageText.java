package llapps.com.recycleviewdemo.been;

/**
 * Created by SongUp on 2018/1/17.
 */

public class ImageText {
    String title;

    private int iconId;
    private String text;
    private int type;

    //文字和图片
    public ImageText(int iconId, String text, int type) {

        this.iconId = iconId;
        this.text = text;
        this.type = type;
    }
//item对应的标题
    public ImageText(String title, int iconId, String text) {
        this.title = title;
        this.iconId = iconId;
        this.text = text;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
