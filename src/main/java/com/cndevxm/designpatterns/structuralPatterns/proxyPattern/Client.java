package com.cndevxm.designpatterns.structuralPatterns.proxyPattern;

public class Client {

    public static void main(String[] args) {
        Searcher searcher = new ProxySearcher(new RealSearcher());
        System.out.println(searcher.search("123", "996.icu"));
        System.out.println(searcher.search("123", "996.icu"));
        System.out.println(searcher.search("123", "996.icu"));
    }
}
