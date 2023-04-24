package map;

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

//        //case 1 String::intern
//        String internCase = "internCase";
//        String internCaseBak = internCase.intern();
//        System.out.println(internCaseBak == internCase);
        String internCase2 = "java".toString();// 常量池里有，直接用的是常量池里的对象
        String internCase2Bak = internCase2.intern();
        System.out.println(internCase2Bak == internCase2);// true 返回的均为常量池中的引用

//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1); //true
        // String::intera 字符串常量池中包含这个字符串的引用，则返回常量池中代表这个String的引用；
        //                如果不包含，则将此String字符串包含的对象添加到常量池中，同时返回此String对象的引用
        // "java" 最开始被 sun.misc.Version 加载 https://www.zhihu.com/question/51102308/answer/124441115
        // 被存档到字符串常量池中
        // 重新 java
        String str2 = new StringBuilder("ja").append("va").toString();//builde对象
        System.out.println(str2.intern() == str2);// fasle

/*        Map map = new HashMap<String, String>();
        Class<? extends Map> mapClass = map.getClass();
        Field[] declaredFields = mapClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            String fieldName = declaredField.getName();
            Object o = declaredField.get(map);
            System.out.println(fieldName + " >>> "+o);
        }*/

    }
}
