package widget.banner;

/**
 * Created by ly on 2017/2/19.
 */

public class BannerEntity {
    private String imgUrl;
    private String action;
    private String title;

    public BannerEntity(String imgUrl, String action) {
        this.imgUrl = imgUrl;
        this.action = action;
    }

    public BannerEntity(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BannerEntity(String imgUrl, String action, String title) {
        this.imgUrl = imgUrl;
        this.action = action;
        this.title = title;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
