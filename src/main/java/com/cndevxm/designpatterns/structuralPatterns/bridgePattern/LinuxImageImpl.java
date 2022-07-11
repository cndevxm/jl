package com.cndevxm.designpatterns.structuralPatterns.bridgePattern;

public class LinuxImageImpl implements ImageImp {
    @Override
    public void doPaint() {
        System.out.println("在Linux下显示图片");
    }
}
