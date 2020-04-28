package learn.thread0221;

import sun.jvm.hotspot.utilities.Assert;

/**
 * 双端加锁
 * Double check Lock
 */
public class SingletionDCL {

    public SingletionDCL(){
        System.out.println(Thread.currentThread().getName()+"初始化");
    }
    public static volatile SingletionDCL singletionDCL;

    public static SingletionDCL getSingletionDCL(){
        if(singletionDCL == null){
                synchronized (SingletionDCL.class){
                    if(singletionDCL == null){
                             singletionDCL =  new SingletionDCL();
                    }
                }
        }
        return  singletionDCL;
    }
    public static void main(String[] args) {
        for(int i = 0 ; i < 1000000 ; i++){
            new Thread(()->{
                SingletionDCL.getSingletionDCL();
            }).start();
        }
    }
}
