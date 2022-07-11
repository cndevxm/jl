package com.cndevxm.designpatterns.constructionalPatterns.prototypePattern;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Date;

/**
 * Created by Yulin Ma
 * Date 2019/3/11
 * Description 周报类 ,Object作为抽象原型类，此类作为具体原型类
 */
@Getter
@Setter
public class WeeklyLog implements Serializable, Cloneable {

    private Attachment attachment;

    private String name;
    private Date date;
    private String content;

    @Override
    protected WeeklyLog clone() {
        System.out.println("调用浅clone方法");
        Object object = null;
        try {
            object = super.clone();
            return (WeeklyLog) object;
        } catch (CloneNotSupportedException e) {
            System.out.println("不支持复制！");
            return null;
        }
    }

    public WeeklyLog deepClone() throws IOException, ClassNotFoundException {
        System.out.println("调用深clone方法");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (WeeklyLog) ois.readObject();
    }
}
