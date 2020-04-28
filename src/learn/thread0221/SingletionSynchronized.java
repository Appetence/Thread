package learn.thread0221;

/**
 * synchronized太重了
 *
 */
public class SingletionSynchronized {
    public SingletionSynchronized(){
        System.out.println("单例模式初始化");
    }
    public static SingletionSynchronized inner ;


    public static synchronized SingletionSynchronized getSingletionSynchronized(){

        if(inner == null){
            inner = new SingletionSynchronized();
        }else{
            return inner;
        }
        return  inner;
    }

    public static void main(String[] args) {
        for(int i = 0 ; i < 10 ; i++){
              new  Thread(()->{
                  SingletionSynchronized.getSingletionSynchronized();
              }).start();
        }
    }
}
