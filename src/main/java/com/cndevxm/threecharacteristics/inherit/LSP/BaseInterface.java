package com.cndevxm.threecharacteristics.inherit.LSP;

import com.cndevxm.threecharacteristics.inherit.LSP.bean.People;

/**
 * Created by Yulin Ma
 * Date 2019/2/28
 * Description
 */
public interface BaseInterface {

    // 吃
    People eat(People people);

    // 喝
    People drink(People people);
}
