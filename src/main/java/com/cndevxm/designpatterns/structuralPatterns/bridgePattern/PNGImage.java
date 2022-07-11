package com.cndevxm.designpatterns.structuralPatterns.bridgePattern;

public class PNGImage extends Image {
    @Override
    public void parseFile(String fileName) {
        System.out.println(fileName + ",图片格式为PNG");
    }
}
