package com.cndevxm.designpatterns.structuralPatterns.proxyPattern;

public class RealSearcher implements Searcher {
    @Override
    public String search(String userName, String keyWord) {
        return "查询结果为：" + keyWord;
    }
}
