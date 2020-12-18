package designPatterns.prototype.shallowClone;

/**
 * @program: ThreadLearn
 * @description: 原型模式  一个对象重复创建的开销较大时候可以将其缓存下来，下次使用的时候返回他的克隆
 * @author: chuchen
 * @create: 2020-12-13 12:45
 */
public class PrototypeShallowClone {

    public static void main(String[] args) throws CloneNotSupportedException {

        PrototypeOwen prototypeOwen = new PrototypeOwen();
        PrototypeOwen prototypeOwen1 = (PrototypeOwen) prototypeOwen.clone();
        PrototypeOwen prototypeOwen2 = (PrototypeOwen) prototypeOwen.clone();
        PrototypeOwen prototypeOwen3 = (PrototypeOwen) prototypeOwen.clone();
        PrototypeOwen prototypeOwen4 = (PrototypeOwen) prototypeOwen.clone();
        System.out.println(prototypeOwen == prototypeOwen1);
        System.out.println(prototypeOwen2 == prototypeOwen1);
        System.out.println(prototypeOwen3.getPrototypeFather() == prototypeOwen1.getPrototypeFather());
        System.out.println(prototypeOwen2.getPrototypeMather() == prototypeOwen1.getPrototypeMather());
        
    }
}
