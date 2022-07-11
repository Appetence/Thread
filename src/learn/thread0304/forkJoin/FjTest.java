package learn.thread0304.forkJoin;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-06-23 14:27
 */
public class FjTest {
    public static void main(String[] args) {
        /**
         * LIFO
         *      栈：先进后出，从top指针取数据
         *
         * FIFO
         *      队列：先进先出，从base指针取数据
         *
         * mode 默认为 LIFO
         */
//        long  64 bit
//        int   32 bit

        // Active counts
        int AC_SHIFT = 48;
        //0001            0001 0000(12)
        long AC_UNIT = 0x0001L << AC_SHIFT;
        // 1111 1111 1111 1111       1111 1111 1111 1111 0000(12)
        long AC_MASK = 0xffffL << AC_SHIFT;


        // Total counts
        int TC_SHIFT = 32;
        //0001            0001 0000(8)
        long TC_UNIT = 0x0001L << TC_SHIFT;
        // 1111 1111 1111 1111       1111 1111 1111 1111 0000(8)
        long TC_MASK = 0xffffL << TC_SHIFT;
        //0001            0100 0000(11)
        long ADD_WORKER = 0x0001L << (TC_SHIFT + 15); // sign


//1111111111111111111111111111111111111111111111111111111111111000
        long np = (long) (-8); // offset ctl counts
        long ctl = (
//      高 16位     低48位
//1111111111111000 0000(12)
                (np << AC_SHIFT)
//1111 1111 1111 1111 0000(12)
                        & AC_MASK)
//      高 16位     低48位
//11111111111111111111111111111000
                | ((np << TC_SHIFT)
//  0000(4)      0100 0000(11)
                & TC_MASK);




        /*
        String is = Integer.toBinaryString(-8);
        System.out.println(is);
        String s = Long.toBinaryString(8l);
        System.out.println(s);
        String s1 = Long.toBinaryString(-8l);
        System.out.println(s1);
//11111111111111111111111111111000
//1000
//1111111111111111111111111111111111111111111111111111111111111000
        */
/*
1001            r
1111            m           r & m = 1001
1110            SQMASK      r & m & SQMASK = 1000
*/

        String s = Integer.toBinaryString(4096);
        System.out.println(s);

        // ctl
        ctl = -1970359196712960l;
        System.out.println(Long.toBinaryString(ctl));
        int max = Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(max));
        max = max + 1;
        System.out.println(Integer.toBinaryString(max));
        int min = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(min));
        // max + 1  == min 所以，int最大标识2^31次方


        int p = 8;
        // 00000000000000000000000000001000
        System.out.println(Integer.toBinaryString(p));
        // 11111111111111111111111111110111  取反
        // 11111111111111111111111111111000  加一 负数用补码标识
        System.out.println(Integer.toBinaryString(-p));

        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(~1));
        System.out.println(~1);
        /**
         * 负数 二进制用补码表示   -1  取反 = 正数
         *
         * -2
         *
         * 11111111111111111111111111111110   取反
         *
         * 00000000000000000000000000000001
         */

        System.out.println(Integer.toBinaryString(-1));
        /**
         * -1
         * 11111111111111111111111111111111  -1 -1  = -2
         *
         * 11111111111111111111111111111110  -2
         */
        System.out.println(">>>");
        System.out.println(Integer.toBinaryString(-1640531527));
        Integer result = -1640531527 & 15;
        System.out.println(Integer.toBinaryString(result));
        int SQMASK = 0x007e;
        System.out.println(Integer.toBinaryString(SQMASK));
        long flag = -4294967296L;
        System.out.println(Long.toBinaryString(flag));
        long ac = (flag + AC_UNIT);
        System.out.println(Long.toBinaryString(ac));
//        System.out.println((AC_MASK & ac) );
        long tc = (flag + TC_UNIT);
        System.out.println(Long.toBinaryString(tc));
//        System.out.println((TC_MASK & tc));
        System.out.println(Integer.toBinaryString(-2147483645));


        p = 9;
        int n = (p > 1) ? p - 1 : 1;
        // p 0000(7) 1000
        n |= n >>> 1;
        // 0000(7) 1000  |  0000(7) 0100   0000(7) 1100
        n |= n >>> 2;
        // 0000(7) 1100  |  0000(7) 0011   0000(7) 1111
        n |= n >>> 4;
        // 0000(7) 1111  | 0000(7) 0000    // 0000(7) 1111
        n |= n >>> 8;
        // 0000(7) 1111                    // 0000(7) 1111
        n |= n >>> 16;
        // 0000(7) 1111
        n = (n + 1) << 1;
        System.out.println(n);
        // 0000(7) 1111    0000(6) 0001 0000     0000(6) 0010 0000          32
        //当p=MAX_CAP的时候，n最终等于2的16次方
        //更有趣的是这个位移，一个数n通过→移动1，2，4，8，16，然后分别于自己取或运算，
        //其实的目的就是把数n二进制表示法的从非零位开始的低位全部变为1，然后最后一步n+1，其实是进1，低位清0，然后再左移1位（容量翻倍）//
        //所以最终的结论就是：工作队列数组的大小，与并行度二进制表示后低位有效位数（k）有关，大小等于2的k+1次方。
        //具体对比可以看下面的**表格2-1**


        // p 0000(6) 0010 0001
        p = 513;
        // 0010 0000 0001
        n = (p > 1) ? p - 1 : 1;
        // 0010 0000 0000
        n |= n >>> 1;
        // 0010 0000 0000     0001 0000 0000        0011 0000 0000
        n |= n >>> 2;
        // 0011 0000 0000     0000 1100 0000        0011 1100 0000
        n |= n >>> 4;
        // 0011 1100 0000     0000 0011 1100        0011 1111 1100
        n |= n >>> 8;
        // 0011 1111 1100     0000 0000 0011        0011 1111 1111
        n |= n >>> 16;
        // 0011 1111 0011
        n = (n + 1) << 1;
        System.out.println(n);
        // 111 1111 1111 1111
        System.out.println(Integer.toBinaryString(0x7fff));

    }
}
