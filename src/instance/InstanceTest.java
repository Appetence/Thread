package instance;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2021-12-17 15:46
 */
public class InstanceTest {
    public static void main(String[] args) {
        C c = new C();
        if(c instanceof A){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
