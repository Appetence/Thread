package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-01-27 13:13
 */
public class ArrayTest {
    public static void main(String[] args) {

        List<String> colums = new ArrayList<>();
        colums.add("1");
        colums.add("2");
        colums.add("3");
        colums.add("4");
        Object[] objects = colums.toArray();
        System.out.println(colums);
        String regEx = "[\\[\\]]";
        Pattern p = Pattern.compile(regEx);
        String str = colums.toString();
        Matcher m = p.matcher(str);
        String result = m.replaceAll("");
        System.out.println(result);
    }
}
