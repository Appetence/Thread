package test;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-02-08 14:32
 */
public class RegexTest {
    public static void main(String[] args) {
        List<String> arr = new LinkedList<>();
        for(int i = 0 ; i < 3 ;i++){
            arr.add(String.valueOf(i));
        }
        System.out.println(arr.toString());
        Pattern p = Pattern.compile("[\\[\\]]|\\s");
        Matcher m = p.matcher(arr.toString());
        String value = m.replaceAll("");
        System.out.println(value);

        Integer integer = new Integer(1);
        Integer integer1 = new Integer(1);
        System.out.println(integer == integer1);
        System.out.println(integer.equals(integer1));
    }
}
