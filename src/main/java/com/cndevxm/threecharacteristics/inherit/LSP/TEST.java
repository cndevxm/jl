package com.cndevxm.threecharacteristics.inherit.LSP;

import com.cndevxm.threecharacteristics.inherit.LSP.bean.People;
import com.cndevxm.threecharacteristics.inherit.LSP.bean.Student;

/**
 * Created by Yulin Ma
 * Date 2019/2/28
 * Description
 */
public class TEST {

    public static void main(String[] args) {

        People people = new People("张三",24);

        Student student = new Student("张小三",8,"市直三小");

        BaseAbstract base = new Base();
        base.sleep(student);

        base.wash(student);


    }
}
