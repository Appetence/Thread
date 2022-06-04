package thread.thread1102;

import com.sun.istack.internal.NotNull;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2021-11-02 14:24
 */
public class NotNullTest {
    public static void main(String[] args) {
        testNull(null);
        testNotNull(null);
        String key1 = "LANZHOU-BK,ZXXJ-ZH,BAOYIN,DWY,HUBEIXJ,HUIJINSUO,MINSHENGXT,PAYPAL,SINAP2P,WACAI,XIAOMA,XIAOYING,XYXJ,XZXT,YUNKE,YUNKEFLOW,YUNKEPERSON,YUNXIN,ZJHK,ZRB,HUBEIXJSF,DWY2,WACAIFLOW,ASD,ZRXT,DWY2,ASDFLOW,ZBYH,JLXD,YUNKEDC,XZXTS,BXBANK,BEIYINXJ,BAOYINXJ_RX,BAOYINXJ_WJ,SICHUANXT,YTBANK,AISHIDE-XD,WAIMAOXT,CHANGYIN-XJ,DAIWEIYING-XD,FQGUANGDA-BK,HAMI-BK,HUATONG-BK,JIUJIANG-BK,SHENGYIN-XJ,XWBANK,YANTAI-BK,ZHONGAN-BX-FLEXIBLE,ZHONGAN-BX-NONFLOW,ZHONGAN-BX-FLOW,ZHONGBANG-BK,ZHONGXIN-XJ,ZRABS-XT,JIUJIANG-BK-FLEXIBLE,YUECAI-XT,JIUJIANG-YZ,JIUJIANG-FLEXIBLE-YZ";
        String key2 = "[YILIAN-BK][JIUJIANG-YZ][JIUJIANG-FLEXIBLE-YZ][ASD][BAOYIN][DWY][DWY2][HUBEIXJ][HUBEIXJSF][HUIJINSUO][MINSHENGXT][PAYPAL][SINAP2P][WACAI][WACAIFLOW][XIAOMA][XIAOYING][XYXJ][XZXT][YUNKE][YUNKEFLOW][YUNKEPERSON][YUNXIN][ZJHK][ZRB][DWY2][ZBYH][JLXD][YUNKEDC][XZXTS][BXBANK][BEIYINXJ][BAOYINXJ_WJ][BAOYINXJ_RX][SICHUANXT][YTBANK][AISHIDE-XD][CHANGYIN-XJ][DAIWEIYING-XD][FQGUANGDA-BK][HAMI-BK][HUATONG-BK][JIUJIANG-BK][SHENGYIN-XJ][WAIMAOXT][XWBANK][YANTAI-BK][ZHONGAN-BX-FLEXIBLE][ZHONGAN-BX-FLOW][ZHONGBANG-BK][ZHONGXIN-XJ][ZRABS-XT][ZHONGAN-BX-NONFLOW][JIUJIANG-BK-FLEXIBLE][YUECAI-XT]";

        String[] split = key1.split(",");

        String[] split1 = key2.replace("[", "").split("]");

        List<String> collect = Arrays.stream(split).collect(Collectors.toList());

        List<String> collect1 = Arrays.stream(split1).collect(Collectors.toList());

//        boolean remove = collect.removeAll(collect1);
        boolean remove = collect1.removeAll(collect);

        System.out.println(collect.size());

        String fundCode = "hami-bk";
    }


    private static void testNotNull(@NotNull String s) {
        System.out.println("testNotNull" + s);
    }

    private static void testNull(@Nullable String s) {
        System.out.println("testNull" + s);
    }
}
