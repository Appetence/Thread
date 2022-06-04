package exception.list;

import java.util.LinkedList;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-04-20 14:11
 */
public class ForeachTest {
    public static void main(String[] args) {
        LinkedList<String> strings = new LinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.forEach((s)->{
            strings.remove();
        });
    }
}
