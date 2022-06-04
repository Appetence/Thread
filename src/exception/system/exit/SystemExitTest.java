package exception.system.exit;

import java.io.IOException;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-04-25 14:16
 */
public class SystemExitTest {
    public static void main(String[] args) throws IOException {
        try{
            System.exit(0);
//            throw new RuntimeException();
        }catch (Throwable t){
            System.out.println(t);
        }finally {
            System.out.println("end");
        }
    }
}
