package com.cndevxm.designpatterns.constructionalPatterns.builderPattern;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Yulin Ma
 * Date 2019/3/13
 * Description
 */

@Getter
@Setter
public class Actor {

    private String type; //角色类型
    private String sex; //性别
    private String face; //脸型
    private String costume; //服装
    private String hairstyle; //发型

}
