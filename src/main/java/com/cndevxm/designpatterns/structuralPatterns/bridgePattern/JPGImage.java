package com.cndevxm.designpatterns.structuralPatterns.bridgePattern;

public class JPGImage extends Image {

    @Override
    public void parseFile(String fileName) {
        System.out.println(fileName + ",图片格式为JPG");
    }
}
