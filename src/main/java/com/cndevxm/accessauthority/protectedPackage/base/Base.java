package com.cndevxm.accessauthority.protectedPackage.base;

/**
 * Created by Yulin Ma
 * Date 2019/1/10
 * Description
 */
public class Base {

    protected String baseName;
    protected int baseAge;

    @Override
    public String toString() {
        return "Base{" +
                "baseName='" + baseName + '\'' +
                ", baseAge=" + baseAge +
                '}';
    }

}
