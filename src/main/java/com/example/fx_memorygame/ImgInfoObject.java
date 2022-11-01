package com.example.fx_memorygame;

import javafx.scene.image.Image;


public class ImgInfoObject {
    String imgName;
    Image img;

    public ImgInfoObject(String imgName, Image img) {
        this.imgName = imgName; // we have tyhe name
        this.img = img; // we have the object
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }
}
