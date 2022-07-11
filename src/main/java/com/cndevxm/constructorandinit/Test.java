package com.cndevxm.constructorandinit;

/**
 * Created by Yulin Ma
 * Date 2019/1/23
 * Description
 */
public class Test {

    public static void main(String[] args) {

        // 通过new 关键字初始化对象
        Children children = new Children();

        /**
         * 类的初始化过程
         *
         * ************
         * 1、因为new用到了Children.class。所以会先找到Children.class文件并加载到内存中。
         * 2、判断Children.class是否有父类，如果有父类将父类文件加载到内存中
         * 3、初始化父类的static修饰的成员变量（只在类加载时调用一次，引用类型默认为null，基础数据类型赋予默认值）
         * 4、执行父类的static静态代码块（只在类加载时调用一次）
         * 5、初始化子类的static修饰的成员变量（只在类加载时调用一次，引用类型默认为null，基础数据类型赋予默认值）
         * 6、执行子类的static静态代码块（只在类加载时调用一次）
         * 7、在堆内存中开辟空间，分配内存地址
         * 8、在堆内存中建立对象的特有属性，并对属性进行初始化，引用类型默认为null，基础数据类型赋予默认值
         * 9、按顺序执行父类的构造代码块
         * 10、执行父类的构造函数
         * 11、按顺序执行子类的构造代码块
         * 12、执行子类的构造函数
         * 13、将内存地址赋值给栈内存中的children变量
         */


        /**
         * 对象构建
         */
    }
}
