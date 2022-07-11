package com.cndevxm.constructorandinit;

/**
 * Created by Yulin Ma
 * Date 2019/1/23
 * Description
 */
public class Base {

    private String baseName = "baba";
    private int baseAge = 100;
    private Long baseWeight = 70L;

    private String baseAddress;
    private int post;

    public static String basepss;
    public static final String basepsfs = "basepsfs";

    private static Dog mydog = new Dog("haha", 1);

    @Override
    public String toString() {
        return "Base{" +
                "baseName=" + baseName +
                ", baseAge=" + baseAge +
                ", baseWeight=" + baseWeight +
                ", baseAddress=" + baseAddress +
                ", post=" + post +
                ", basepss=" + basepss +
                ", basepsfs=" + basepsfs +
                '}';
    }

    {
        System.out.println("父类构造代码块1被调用。。。");
        System.out.println(this.toString());
    }

    public Base() {
        System.out.println("父类无参构造器被调用。。。");
    }

    public Base(String baseName, int baseAge, Long baseWeight) {
        System.out.println("父类有参参构造器被调用。。。");
        this.baseName = baseName;
        this.baseAge = baseAge;
        this.baseWeight = baseWeight;
    }

    {
        System.out.println("父类构造代码块2被调用。。。");
    }

    static {
        System.out.println(("basepss:" + Base.basepss + ",basepsfs:" + Base.basepsfs));
        System.out.println("父类静态代码块被调用。。。");
    }


}
