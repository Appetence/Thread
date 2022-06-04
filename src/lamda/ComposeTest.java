package lamda;

import java.util.function.Function;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-06-01 21:26
 */
public class ComposeTest {
    public static void main(String[] args) {
        Function<Integer, Integer> triangle = arg -> arg * 3;
        Function<Integer, Integer> square = arg -> arg * arg;
        int result1 = triangle.apply(2); //result1: 3
        int result2 = square.apply(3);//result2: 1


        Function<Integer, Integer> area1 = triangle.compose(square);
        Function<Integer, Integer> area2 = square.compose(triangle);
        Integer apply1 = area1.apply(1);//tri(squ(1))
        Integer apply = area2.apply(1);//squ(tri(1))
        System.out.println(apply1);
        System.out.println(apply);
        Function<Integer, Function<Integer, Integer>> add = x -> (y -> (x + y));
        Integer apply2 = add.apply(3).apply(5);//result: 8
        System.out.println(">>" + apply2);

        Function<Integer, Function<Integer, Function<Integer, Integer>>> axPlusb = a -> (x -> (b -> (a * x + b)));
        int yz = axPlusb.apply(2).apply(3).apply(4);

        System.out.println(">>" + yz);

        Function<Function<Integer, Integer>, Function<Function<Integer, Integer>, Function<Integer, Integer>>> compose = x -> y -> z -> (x.apply(y.apply(z)));

        Integer apply3 = compose.apply(triangle).apply(triangle).apply(1);
        System.out.println(apply3);

        String string = func().apply("A").apply("B").apply("C").apply("D");
        System.out.println(string);
        String func = func("A", "B", "C", "D");
        System.out.println(func);
        Function<Integer, Function<Integer, Integer>> integerFunctionFunction = reverseArgs(add);
        Integer apply4 = integerFunctionFunction.apply(1).apply(1);
        System.out.println(apply4);
        Function<String,String> function = Function.identity();
        String strValue = testIdentity(function);
        System.out.println(strValue);

    }

    //将以下函数转换成一个柯里化函数
    static <A, B, C, D> String func(A a, B b, C c, D d) {
        return String.format("%s %s %s %s", a, b, c, d);
    }

    //在转换前,我们只需要知道多层输入的类型和输出,那么就可以简单地写出方法的签名了
    static <A, B, C, D> Function<A, Function<B, Function<C, Function<D, String>>>> func()
//然后就是实现了,实现起来十分简单,就是单输入柯里化的嵌套
    {
        return a -> b -> c -> d -> String.format("%s %s %s %s", a, b, c, d);
    }

    //应用也很简单
    public static <T, U, V> Function<U, Function<T, V>> reverseArgs(Function<T, Function<U, V>> f) {
        return u -> t -> f.apply(t).apply(u);
    }
//仍然是那句话,我们需要跟着参数走,函数f apply的顺序是不会变的,我们要改变的是柯里化传值的顺序

    public static String testIdentity(Function<String,String> function) {
        return function.apply("hello world");
    }
}
