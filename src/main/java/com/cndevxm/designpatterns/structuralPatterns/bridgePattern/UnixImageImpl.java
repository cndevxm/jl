package com.cndevxm.designpatterns.structuralPatterns.bridgePattern;

public class UnixImageImpl implements ImageImp {
    @Override
    public void doPaint() {
        System.out.println("在Unix下显示图片");
    }
}
