package access.synthetic;

import java.util.Calendar;
import static java.lang.System.out;

/**
 * @program: ThreadLearn
 * @description: synthetic  编译器为了方便内部类的私有成员被外部类引用，生成了一个get方法，这可以被理解为一个trick，绕开了private成员变量的限制。
 * @author: xiamu
 * @create: 2021-04-20 15:24
 */
public final class DemonstrateSyntheticMethods
{
    public static void main(final String[] arguments)
    {
        DemonstrateSyntheticMethods.NestedClass nested =
                new DemonstrateSyntheticMethods.NestedClass();
        out.println("String: " + nested.highlyConfidential);
    }

    private static final class NestedClass
    {
        private String highlyConfidential = "Don't tell anyone about me";
        private int highlyConfidentialInt = 42;
        private Calendar highlyConfidentialCalendar = Calendar.getInstance();
        private boolean highlyConfidentialBoolean = true;
    }
}