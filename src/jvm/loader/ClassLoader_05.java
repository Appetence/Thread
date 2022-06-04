package jvm.loader;

import jvm.loader.custom.CustomClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-11 17:36
 */
public class ClassLoader_05 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        Class<?> aClass = customClassLoader.findClass("jvm.loader.SupClass");
        System.out.println(aClass);
        //获取代理对象
        Object obj = aClass.newInstance();
        Method[] methods = aClass.getMethods();
        Arrays.stream(methods).forEach(m -> {
            System.out.println(m);
        });
        //获取方法
        Method unShow = aClass.getMethod("unShow");
        //方法执行，并获取结果
        Object invoke = unShow.invoke(obj);
        System.out.println(invoke);
        //执行带参方法
        Method show = aClass.getMethod("show", String.class);
        Object invokeShow = show.invoke(obj, "invokeShow");
        System.out.println(invokeShow);

    }
}
