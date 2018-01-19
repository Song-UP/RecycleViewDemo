package llapps.com.recycleviewdemo.been;

/**
 * Created by wusong on 2018/1/18.
 */

public class ImageText {
    private String Title;

    private String text;
    private String imageUrl;
    private int iconId;

    private int type;
    private int span;

    public ImageText(String title, String text) {
        Title = title;
        this.text = text;
    }


    public ImageText(String Title, String imageUrl, int type, int span) {
        this.Title = Title;
        this.imageUrl = imageUrl;
        this.type = type;
        this.span = span;
    }

    public ImageText(int ic_launcher, String text, int type) {
        this.iconId = ic_launcher;
        this.text = text;
        this.type = type;

    }

    public ImageText(String title, int type, String text) {
        Title = title;
        this.type = type;
        this.text = text;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSpan() {
        return span;
    }

    public void setSpan(int span) {
        this.span = span;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }
}
