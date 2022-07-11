package com.cndevxm.designpatterns.structuralPatterns.bridgePattern;

public class WindowsImageImpl implements ImageImp {
    @Override
    public void doPaint() {
        System.out.println("在Windows下显示图片");
    }
}
