package com.cndevxm.designpatterns.structuralPatterns.compositePattern.safetyCompositePattern;

public class Client {

    public static void main(String[] args) {

        // 总公司
        Subsidiary head = new Subsidiary("总公司");
        Unit headDev = new DevGroup("总公司开发组");
        Unit headTest = new TestGroup("总公司测试组");
        Unit headProduct = new ProductGroup("总公司产品组");
        head.add(headDev);
        head.add(headTest);
        head.add(headProduct);

        // 北京分公司
        Subsidiary bj = new Subsidiary("北京分公司");
        Unit bjDev = new DevGroup("北京分公司开发组");
        Unit bjTest = new TestGroup("北京分公司测试组");
        Unit bjProduct = new ProductGroup("北京分公司产品组");
        bj.add(bjDev);
        bj.add(bjTest);
        bj.add(bjProduct);
        head.add(bj);

        // 北京朝阳部门
        Subsidiary bjcy = new Subsidiary("北京分公司朝阳分部");
        Unit bjcyDev = new DevGroup("北京分公司朝阳分部开发组");
        Unit bjcyTest = new TestGroup("北京分公司朝阳分部测试组");
        Unit bjcyProduct = new ProductGroup("北京分公司朝阳分部产品组");
        bjcy.add(bjcyDev);
        bjcy.add(bjcyTest);
        bjcy.add(bjcyProduct);
        bj.add(bjcy);

        // 北京西城部门
        Subsidiary bjxc = new Subsidiary("北京分公司西城分部");
        Unit bjxcDev = new DevGroup("北京分公司西城分部开发组");
        Unit bjxcTest = new TestGroup("北京分公司西城分部测试组");
        Unit bjxcProduct = new ProductGroup("北京分公司西城分部产品组");
        bjxc.add(bjxcDev);
        bjxc.add(bjxcTest);
        bjxc.add(bjxcProduct);
        bj.add(bjxc);

        // 上海分公司
        Subsidiary sh = new Subsidiary("上海分公司");
        Unit shDev = new DevGroup("上海分公司开发组");
        Unit shTest = new TestGroup("上海分公司测试组");
        Unit shProduct = new ProductGroup("上海分公司产品组");
        sh.add(shDev);
        sh.add(shTest);
        sh.add(shProduct);
        head.add(sh);

        // 上海浦东部门
        Subsidiary shpd = new Subsidiary("上海分公司浦东分部");
        Unit shpdDev = new DevGroup("上海分公司浦东分部开发组");
        Unit shpdTest = new TestGroup("上海分公司浦东分部测试组");
        Unit shpdProduct = new ProductGroup("上海分公司浦东分部产品组");
        shpd.add(shpdDev);
        shpd.add(shpdTest);
        shpd.add(shpdProduct);
        sh.add(shpd);

        // 上海徐汇部门
        Subsidiary shxh = new Subsidiary("上海分公司徐汇分部");
        Unit shxhDev = new DevGroup("上海分公司徐汇分部开发组");
        Unit shxhTest = new TestGroup("上海分公司徐汇分部测试组");
        Unit shxhProduct = new ProductGroup("上海分公司徐汇分部产品组");
        shxh.add(shxhDev);
        shxh.add(shxhTest);
        shxh.add(shxhProduct);
        sh.add(shxh);

        head.sendMessage("五一放假");
    }
}
