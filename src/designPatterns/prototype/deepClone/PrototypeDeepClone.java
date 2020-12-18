package designPatterns.prototype.deepClone;

import designPatterns.prototype.PrototypeOwen;

/**
 * @program: ThreadLearn
 * @description: 原型模式  一个对象重复创建的开销较大时候可以将其缓存下来，下次使用的时候返回他的克隆
 * @author: chuchen
 * @create: 2020-12-13 12:45
 */
public class PrototypeDeepClone {
    public static void main(String[] args) {
        PrototypeOwen prototypeOwen = new PrototypeOwen();
        PrototypeOwen prototypeOwen1 = prototypeOwen.deepClone();
        PrototypeOwen prototypeOwen2 = prototypeOwen.deepClone();
        PrototypeOwen prototypeOwen3 = prototypeOwen.deepClone();
        PrototypeOwen prototypeOwen4 = prototypeOwen.deepClone();
        System.out.println(prototypeOwen);
        System.out.println(prototypeOwen1);
        System.out.println(prototypeOwen2);

        System.out.println(prototypeOwen == prototypeOwen1);
        System.out.println(prototypeOwen.getPrototypeMather() == prototypeOwen1.getPrototypeMather());

    }


}
