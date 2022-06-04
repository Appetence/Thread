package jvm.loader;

import java.util.List;

/**
 * @program: ThreadLearn
 * @description: 双亲委派
 * @author: xiamu
 * @create: 2021-03-11 16:12
 */
public class ClassLoader_04 {
    public static void main(String[] args) {
        /**
         * 类加载器
         *      1。bootstrap classloader 启动类加载器，根类加载器，负责java核心类库 加载如(%JAVA_HOME%/lib)目录 rn.jar （包含System、String这样的核心类）这样的核心类库。根类加载器非常特殊，它不是java.lang.ClassLoader的子类，它是JVM自身内部由C/C++实现的，并不是Java实现的。
         *      2。Extension classloader 扩展类加载器 加载(%JAVA_HOME%/jre/lib/ext)路径下的jar包 用户可以把自己开发的类打包成jar包放在这个目录下即可扩展核心类以外的新功能。
         *      3、System ClassLoader\APP ClassLoader：系统加载器/应用程序加载器 是加载CLASSPATH环境变量所指定的jar包与类路径。一般来说，用户自定义的类就是由APP ClassLoader加载的。
         *      4。自定义类加载器
         *
         * 各种类加载器间关系：以组合关系复用父类加载器的父子关系，注意，这里的父子关系并不是以继承关系实现的。
         *
         * 双亲委派类加载机制：读取到class文件后，类加载器不会直接去解析class文件，而是先把请求委派给父类去加载，每一层都是如此，因此所有的加载请求都应该传递到启动类加载器（bootstrap）中加载，只有当父类加载器反馈自己无法处理这个请求时候（在它的加载路径下没有找到所需加载的Class），子类才会自己尝试去加载
         *
         *
         *
         */
        //输出ClassLoaderText的类加载器名称
        System.out.println("ClassLoaderText类的加载器的名称:" + SupClass.class.getClassLoader().getClass().getName());
        System.out.println("System类的加载器的名称:" + System.class.getClassLoader());
        System.out.println("List类的加载器的名称:" + List.class.getClassLoader());

        ClassLoader cl = SupClass.class.getClassLoader();
        while (cl != null) {
            System.out.print(cl.getClass().getName() + "->");
            cl = cl.getParent();
        }
        System.out.println(cl);


        //获取类加载器加载路径
        System.out.println(">>>>>>>>>>> boot");
        System.out.println(System.getProperty("sun.boot.class.path").replace(":", System.lineSeparator()));
        System.out.println(">>>>>>>>>>> ext");
        System.out.println(System.getProperty("java.ext.dirs").replace(":", System.lineSeparator()));
        System.out.println(">>>>>>>>>>> app");
        System.out.println(System.getProperty("java.class.path").replace(":", System.lineSeparator()));
        System.out.println(">>>>>>>>>>> end");
    }


}
