package designPatterns.prototype.cache;

import designPatterns.prototype.PrototypeFather;
import designPatterns.prototype.PrototypeMather;
import designPatterns.prototype.PrototypeOwen;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @program: ThreadLearn
 * @description: 原型模式  一个对象重复创建的开销较大时候可以将其缓存下来，下次使用的时候返回他的克隆
 * @author: chuchen
 * @create: 2020-12-13 12:45
 */
public class PrototypeCache {

    private static HashMap<String, Prototype> map = new HashMap<>();

    public static Prototype getPrototype(String type) {
        if (map.get(type) == null) {
            return null;
        } else {
            try {
                return (Prototype) map.get(type).clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    public static void initProperty() {
        Prototype prototypeFather = new PrototypeFather("父亲", "我的父亲");
        prototypeFather.setType("father");
        Prototype prototypeMather = new PrototypeMather("母亲", "我的母亲");
        prototypeMather.setType("mather");
        Prototype prototypeOwen = new PrototypeOwen();
        prototypeOwen.setType("owen");
        map.put(prototypeFather.getType(), prototypeFather);
        map.put(prototypeMather.getType(), prototypeMather);
        map.put(prototypeOwen.getType(), prototypeOwen);
    }


    public static void main(String[] args) {
        initProperty();
        Prototype prototype = getPrototype("father");
        Prototype prototype1 = getPrototype("father");
        Prototype prototype2 = getPrototype("father");
        Prototype prototype3 = getPrototype("father");
        System.out.println(prototype);
        System.out.println(prototype1);
        System.out.println(prototype == prototype1);
    }


}
