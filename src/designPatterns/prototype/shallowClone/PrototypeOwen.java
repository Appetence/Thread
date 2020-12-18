package designPatterns.prototype.shallowClone;

import designPatterns.prototype.PrototypeFather;
import designPatterns.prototype.PrototypeMather;

/**
 * @program: ThreadLearn
 * @description:
 * @author: chuchen
 * @create: 2020-12-13 13:33
 */
public class PrototypeOwen implements Cloneable {
    private String name = "我自己";
    private String age = "10";
    private String address = "北京市昌平区";
    private String sex = "男";
    private PrototypeFather prototypeFather = new PrototypeFather("父亲", "我是爸爸");
    private PrototypeMather prototypeMather = new PrototypeMather("母亲", "我是妈妈");


    public PrototypeOwen() {
    }

    public PrototypeOwen(String name, String age, String address, String sex) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PrototypeOwen{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", prototypeFather=" + prototypeFather +
                ", prototypeMather=" + prototypeMather +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public PrototypeFather getPrototypeFather() {
        return prototypeFather;
    }

    public void setPrototypeFather(PrototypeFather prototypeFather) {
        this.prototypeFather = prototypeFather;
    }

    public PrototypeMather getPrototypeMather() {
        return prototypeMather;
    }

    public void setPrototypeMather(PrototypeMather prototypeMather) {
        this.prototypeMather = prototypeMather;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //sheng qi e拷贝
        return super.clone();
    }
}
