package leetcode.binary;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2022-08-30 08:11
 */
public class Learn02 {
    /**
     * 一个数出现奇数次  其他数出现偶数次
     * 求出现奇数次的数的值
     *
     * eor 异或运算
     */

    /**
     * 异或运算交换两个数
     * 注意，两个数不能在同一片内存空间中
     */

    /**
     * 一个int 类型数 二进制最右边的1
     *
     * a & (- a ) = a & (~a + 1)
     */

    /**
     * arr 中有两种数出现奇数次  其他书出现偶数次 求这俩数
     *
     *
     * 奇数，两种，肯定不相同
     * eor记录所有数异或结果
     * eor最右侧的1 rightOne
     *
     * eor' 异或所有 rightOne & item 为1 的数据  获取到  其中一个数
     * eor ^ eor' == 另一个数
     *
     * eor'记录
     *
     * 最右侧为1 分一波
     * 其他分一波
     *
     *
     *
     */
    /**
     * 数组 arr  其他所有数出现了M次 一种数出现了K次  0 < K < M
     *
     * 时间复杂福 O(n)  空间复杂度 O(1)
     *
     * 二进制表示，Integer    每一位出现一次+1        最终每一位不能能被M整除的  就是出现K次的数
     */
}
