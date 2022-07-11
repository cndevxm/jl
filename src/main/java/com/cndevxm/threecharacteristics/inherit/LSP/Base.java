package com.cndevxm.threecharacteristics.inherit.LSP;

import com.cndevxm.threecharacteristics.inherit.LSP.bean.People;
import com.cndevxm.threecharacteristics.inherit.LSP.bean.Student;

/**
 * Created by Yulin Ma
 * Date 2019/2/28
 * Description
 */
public class Base extends BaseAbstract{


    @Override
    public People eat(People people) {
        System.out.println((people.getName() + "吃过饭了"));
        return people;
    }

    @Override
    public People drink(People people) {
        System.out.println((people.getName() + "喝过水了"));
        return people;
    }

    @Override
    Student bathe(People people) {
        return null;
    }


    Student sleep(People people) {
        System.out.println((people.getName() + "睡过觉了"));
        return new Student();
    }

    @Override
    Student wash(Student student) {
        System.out.println((student.getName() + "洗漱过了2"));
        return new Student();
    }
}
