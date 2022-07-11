package com.cndevxm.designpatterns.constructionalPatterns.prototypePattern;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Yulin Ma
 * Date 2019/3/11
 * Description 周报附件类
 */

@Getter
@Setter
public class Attachment implements Serializable {

    private String name;

    public void download() {
        System.out.println("开始下载附件");
    }
}
