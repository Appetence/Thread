package jvm.gurbage;

import base.Xiamu;
import com.xiamu.agent.XiamuAgent;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-05-14 14:47
 */
public class GC1 {
    public static void main(String[] args) {
        Xiamu xiamu = new Xiamu();
        System.out.println(xiamu);
        xiamu = null;

    }
}
