package com.cndevxm.designpatterns.structuralPatterns.bridgePattern;

public abstract class Image {

    private ImageImp imageImp;

    public ImageImp getImageImp() {
        return imageImp;
    }

    public void setImageImp(ImageImp imageImp) {
        this.imageImp = imageImp;
    }

    public abstract void parseFile(String fileName);
}
