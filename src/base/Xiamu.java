package base;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-05-14 14:49
 */

public class Xiamu {
    private String name;
    private String local;
    private String agemt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAgemt() {
        return agemt;
    }

    public void setAgemt(String agemt) {
        this.agemt = agemt;
    }

    public Xiamu() {
        this.name = "name";
        this.local = "local";
        this.agemt = "agemt";
    }

    public Xiamu(String name, String local, String agemt) {
        this.name = name;
        this.local = local;
        this.agemt = agemt;
    }

    @Override
    public String toString() {
        return "Xiamu{" +
                "name='" + name + '\'' +
                ", local='" + local + '\'' +
                ", agemt='" + agemt + '\'' +
                '}';
    }

    /**
     * 对象被gc之前会调用该方法
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        /**
         * 该方法仅会被调用一次，尽量避免在中介写业务
         * 当一个对象在某一时刻被标记为无引用的garbage时候会在垃圾回收之前调用
         * 但是当垃圾回收之前，该对象有被引用了，在下一次回收的时候不会调用finalize方法
         */
        //super.finalize();
        System.out.println("xiamu soft reference");
    }
}
