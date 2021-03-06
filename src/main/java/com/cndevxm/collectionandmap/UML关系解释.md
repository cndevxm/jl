### 类的显示与接口的显示
* 类与接口的显示
    * 类的显示为一个长方形分为三部分；
    * 第一部分为类名，抽象类显示为斜体，接口显示为<<接口名>>；
    * 第二部门显示为类属性列表：可见性 + 属性名 + 冒号 + 属性类型 + （等号 + 默认值）
    * 第三部分显示为类方法列表：可见性 + 函数名 + (参数列表) + 冒号 + 返回值类型
    * 可见性：+ 代表public,- 代表private,# 代表protected, ~ 代表package
### 类和接口之间的关系
* 泛化
    * 继承类 显示为一条实线空心三角指向基类
* 实现

    *  显示为一条虚线空心三角指向接口
* 关联
    * 表示一种拥有的关系，它使一个类知道另外一个类的属性和方法，代码体现为成员变量
    * 双向关联 实线或者两端带箭头的实线连接双方，实线上端写上关联关系，实线下端写上可能的多重值，多重值表示为数字代表个数，..代表或者，*代表多个，比如老师与学生
    * 单线关联 实线加上箭头，箭头代表has关系，比如学生与课程
* 聚合
    * 表示一种整体与部分的关系，部分可以离开整体而单独存在，代码体现为成员变量，是一种比较强的关联关系
    * 用一个带实线的空心菱形指向整体，箭头指向部分，比如车辆与轮胎的关系
* 组合

    * 表示一种整体与部分的关系，部分离开整体后不能单独存在，代码体现为成员变量，是一种比聚合还要强的关联关系
    * 用一个带实线的实心菱形指向整体，箭头指向部分，比如公司与部门的关系
* 依赖
    * 表示一种使用的关系，一个类的功能实线需要另外一个类的协助，我们要尽量避免双向依赖
    * 代码体现 将一个类的对象作为另一个类中方法入参，局部变量，调用另外类的静态方法
    * 用一个带箭头的虚线指向被使用的一方或者是带虚线的实心三角，比如人与计算机的关系
