package classLearn.fileds;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2021-11-19 11:47
 */
public class FiledsTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "aaa");
        map.put("bbb", "bbb");

        Class<? extends Map> mapClass = map.getClass();
        Field[] declaredFields = mapClass.getDeclaredFields();
        if (declaredFields != null) {
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField);
            }
        }
        Field table = mapClass.getDeclaredField("table");
        //override本质=true 后续获取属性时候!override=false不在调用checkAccess方法
        table.setAccessible(true);
        Object o = table.get(map);
        System.out.println(o);

    }


}
