package com.cndevxm.threecharacteristics.inherit.LSP;

import com.cndevxm.threecharacteristics.inherit.LSP.bean.People;
import com.cndevxm.threecharacteristics.inherit.LSP.bean.Student;

/**
 * Created by Yulin Ma
 * Date 2019/2/28
 * Description
 */
public abstract class BaseAbstract implements BaseInterface{

    // 洗澡
    abstract People bathe(People people);

    // 睡觉
    People sleep(Student student) {
        System.out.println((student.getName() + "在教室休息完成"));
        return new People();
    }

    People wash(Student student){
        System.out.println((student.getName() + "洗漱过了1"));
        return new People();
    }
}
