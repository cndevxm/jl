package com.cndevxm.designpatterns.structuralPatterns.bridgePattern;

public class Client {

    public static void main(String[] args) {
        Image image = new GIFImage();
        image.setImageImp(new WindowsImageImpl());

        image.parseFile("123");
        image.getImageImp().doPaint();
    }
}
