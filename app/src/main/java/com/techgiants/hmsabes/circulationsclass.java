package com.techgiants.hmsabes;

public class circulationsclass{
    private String image;
    private String title;
    private String data;
    private String time;
    private String key;
    private String notice;

    public String getData() {
        return data;
    }
    public String getNotice() {
        return notice;
    }
    public void setNotice(String notice) {
        this.notice = notice;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getImg() {
        return image;
    }

    public void setImg(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public circulationsclass() {
    }
}
