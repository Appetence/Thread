package thread.thread1102;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2021-11-02 14:11
 */
public class StringTest {
    public static void main(String[] args) throws IllegalAccessException {
        String conternt = " _   _";
        String trim = conternt.trim();
        System.out.println(trim);

        System.out.println(new String("__!!!!__".toCharArray(), 2, 3));
        System.out.println(">>>");
        System.out.println(new String("__!!".toCharArray(), 1, 3));

        Map map = new HashMap<String, String>();
        Class<? extends Map> mapClass = map.getClass();
        Field[] declaredFields = mapClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String fieldName = declaredField.getName();
            Object o = declaredField.get(map);
            System.out.println(fieldName);
        }

    }
}
