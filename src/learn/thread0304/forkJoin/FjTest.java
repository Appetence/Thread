package learn.thread0304.forkJoin;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-06-23 14:27
 */
public class FjTest {
    public static void main(String[] args) {
//        long  64 bit
//        int   32 bit

        // Active counts
       int  AC_SHIFT   = 48;
       //0001            0001 0000(12)
       long AC_UNIT    = 0x0001L << AC_SHIFT;
       // 1111 1111 1111 1111       1111 1111 1111 1111 0000(12)
       long AC_MASK    = 0xffffL << AC_SHIFT;


        // Total counts
        int  TC_SHIFT   = 32;
        //0001            0001 0000(8)
        long TC_UNIT    = 0x0001L << TC_SHIFT;
        // 1111 1111 1111 1111       1111 1111 1111 1111 0000(8)
        long TC_MASK    = 0xffffL << TC_SHIFT;
        //0001            0100 0000(11)
        long ADD_WORKER = 0x0001L << (TC_SHIFT + 15); // sign


//1111111111111111111111111111111111111111111111111111111111111000
        long np = (long)(-8); // offset ctl counts
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


    }
}
