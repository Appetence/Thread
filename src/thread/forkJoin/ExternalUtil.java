package thread.forkJoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @program: Thread
 * @description:
 * @author: liuhao
 * @date: 2022-12-07 15:49
 */
public class ExternalUtil {
    // Lower and upper word masks
    private static final long SP_MASK = 0xffffffffL;
    private static final long UC_MASK = ~SP_MASK;

    // Active counts
    private static final int AC_SHIFT = 48;
    private static final long AC_UNIT = 0x0001L << AC_SHIFT;
    private static final long AC_MASK = 0xffffL << AC_SHIFT;

    // Total counts
    private static final int TC_SHIFT = 32;
    private static final long TC_UNIT = 0x0001L << TC_SHIFT;
    private static final long TC_MASK = 0xffffL << TC_SHIFT;
    private static final long ADD_WORKER = 0x0001L << (TC_SHIFT + 15); // sign
    // Bounds
    static final int SMASK = 0xffff;        // short bits == max index
    static final int MAX_CAP = 0x7fff;        // max #workers - 1
    static final int EVENMASK = 0xfffe;        // even short bits
    static final int SQMASK = 0x007e;        // max 64 (even) slots

    // Masks and units for WorkQueue.scanState and ctl sp subfield
    static final int SCANNING = 1;             // false when running tasks
    static final int INACTIVE = 1 << 31;       // must be negative
    static final int SS_SEQ = 1 << 16;       // version count

    // Mode bits for ForkJoinPool.config and WorkQueue.config
    static final int MODE_MASK = 0xffff << 16;  // top half of int
    static final int LIFO_QUEUE = 0;
    static final int FIFO_QUEUE = 1 << 16;
    static final int SHARED_QUEUE = 1 << 31;       // must be negative
    private static final int SEED_INCREMENT = 0x9e3779b9;
    public static int indexSeed = 0;

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(SQMASK));
        long ctl = -1970359196712960l;
        System.out.println(Long.toBinaryString(ctl));
        //1111111111111000111111111111100000000000000000000000000000000000
        long np = -8;
        // 8 : 0000 0000 0000 1000
        System.out.println(Long.toBinaryString(8l));
        // -8: 1111111111111111111111111111111111111111111111111111111111111000
        // 负数，二进制，补码表示， 反码+ 1
        System.out.println(Long.toBinaryString(-8l));

        ctl = ((np << AC_SHIFT) & AC_MASK) | ((np << TC_SHIFT) & TC_MASK);
        System.out.println(Long.toBinaryString(ctl));

        System.out.println(Integer.toBinaryString(SEED_INCREMENT));
        int count = 20;
        for (int i = 0; i < count; i++) {
            // 本质 取指定范围内递增奇数
            seedIncrementCycle();
        }
        collision();

    }

    private static void collision() {
        System.out.println("collision begin ");
        int n = 16;
        int m = n - 1;
        int i = 15;
        ForkJoinPool[] workQueues = new ForkJoinPool[n];
        ForkJoinPool[] ws = workQueues;
        int probes = 0;                   // step by approx half n
        int step = (n <= 4) ? 2 : ((n >>> 1) & EVENMASK) + 2;
        while (ws[i = (i + step) & m] != null) {
            if (++probes >= n) {
                workQueues = ws = Arrays.copyOf(ws, n <<= 1);
                m = n - 1;
                probes = 0;
            }
        }
        System.out.println("collision end ");
    }

    private static void seedIncrementCycle() {
        int n = 16;
        int m = n - 1;
        // SEED_INCREMENT 10011110001101110111100110111001
        int s = indexSeed += SEED_INCREMENT;  // unlikely to collide
        int i = ((s << 1) | 1) & m;
        System.out.println(i);
    }
}
