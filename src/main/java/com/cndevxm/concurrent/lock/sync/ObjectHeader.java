package com.cndevxm.concurrent.lock.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * 验证无锁、偏向锁、轻量级锁、重量级锁的对象头的值
 * <p>
 * 对象头的构造
 * |--------------------------------------------------------------------------------------------------------------|
 * |                                              Object Header (128 bits)                                        |
 * |--------------------------------------------------------------------------------------------------------------|
 * |                        Mark Word (64 bits)                                    |      Klass Word (64 bits)    |
 * |--------------------------------------------------------------------------------------------------------------|
 * |  unused:25 | identity_hashcode:31 | unused:1 | age:4 | biased_lock:1 | lock:2 |     OOP to metadata object   |  无锁
 * |----------------------------------------------------------------------|--------|------------------------------|
 * |  thread:54 |         epoch:2      | unused:1 | age:4 | biased_lock:1 | lock:2 |     OOP to metadata object   |  偏向锁
 * |----------------------------------------------------------------------|--------|------------------------------|
 * |                     ptr_to_lock_record:62                            | lock:2 |     OOP to metadata object   |  轻量锁
 * |----------------------------------------------------------------------|--------|------------------------------|
 * |                     ptr_to_heavyweight_monitor:62                    | lock:2 |     OOP to metadata object   |  重量锁
 * |----------------------------------------------------------------------|--------|------------------------------|
 * |                                                                      | lock:2 |     OOP to metadata object   |    GC
 * |--------------------------------------------------------------------------------------------------------------|
 * 名词解释
 * identity_hashcode：hashcode
 * age：年龄分代
 * lock：锁状态标识，00：无锁或者偏向锁，01：轻量级锁，10：重量级锁，11：GC
 * biased_lock：偏向锁标识，0：无偏向锁，1：偏向锁
 * thread：偏向线程id
 * epoch：偏向时间戳
 * ptr_to_lock_record：线程栈中锁记录指针
 * ptr_to_heavyweight_monitor：重量级锁对象监视器指针
 * <p>
 * <p>
 * <p>
 * 验证条件：
 * 1、关闭指针压缩，-XX:-UseCompressedOops
 */

public class ObjectHeader {

    private String code;

    public static void main(String[] args) {

        //
        ObjectHeader objectHeader = new ObjectHeader();
        objectHeader.hashCode();
        System.out.println(ClassLayout.parseInstance(objectHeader).toPrintable());


    }


}
