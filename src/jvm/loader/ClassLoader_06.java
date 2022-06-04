package jvm.loader;

import jvm.loader.custom.CustomAscClassLoader;
import jvm.loader.custom.CustomClassLoader;
import jvm.loader.custom.ShuffleClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @program: ThreadLearn
 * @description: 自定义classloader加解密文件
 * @author: xiamu
 * @create: 2021-03-11 17:36
 */
public class ClassLoader_06 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        ShuffleClassLoader customClassLoader = new ShuffleClassLoader();
//        CustomAscClassLoader customClassLoader = new CustomAscClassLoader();
//        CustomClassLoader customClassLoader = new CustomClassLoader();
//        Class<?> aClass = customClassLoader.findClass("~/Users/liuhao/Downloads/workspake/ThreadLearn/out/production/ThreadLearn/jvm/loader/SupClass.class");
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
        Method show1 = aClass.getMethod("show", String.class,String.class);
        Object invokeShow1 = show1.invoke(obj, "invokeShow","invokeShow1");
        System.out.println(invokeShow1);




    }
}
