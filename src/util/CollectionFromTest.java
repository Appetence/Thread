package util;

import org.springframework.lang.Nullable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-06-08 14:18
 */
public class CollectionFromTest {
    private static class SA{
        private String  k;
        private String v;

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
         /*String key = "1110382|32954|06317|00|6880630108|01009601012116213537397871834|2021-05-19|1|110.76|0.00|202105190110006880630108|2021-05-19 00:02:20|||徐晴|230202********002*|621700*********4496|15645010815|||||||";
        Object[] objects = Arrays.stream(key.split("\\|")).toArray();
        System.out.println(objects.length);
        HashMap<String, String> shareMap = new HashMap<>();
        shareMap.put("a","a");
        try (ByteArrayOutputStream os = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(os);){
            oos.writeObject(shareMap);
            System.out.println( os.toByteArray());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        SA sa = new SA();
        sa.setK("");

        System.out.println("");

        String s = "商户号|终端号|交易类型|交易子类型|总笔数|总金额|总手续费|清算时间\r\n1110382|32954|04317|00|17717|9114515.81|4325.70|2021-05-19\r\n1110382|52135|04317|00|34|1879.37|53.46|2021-05-19\r\n商户号|终端号|交易类型|交易子类型|宝付订单号|商户订单号|清算日期|订单状态|交易金额|手续费|宝付交易号|支付订单创建时间|商户退款订单号|退款订单创建时间|持卡人姓名-支付|持卡人身份证号-支付|银行卡号-支付|预留手机号-支付|持卡人姓名-退款|银行卡号-退款|分账商户号|分账金额|分账子商户手续费|分账创建时间|分账更新时间\r\n1110382|58839|06317|00|6880628175|01009601012116213536022571834|2021-05-19|1|13709.87|0.00|202105190110006880628175|2021-05-19 00:00:04|||勐阁|150402********243*|621700*********0749|13664769255|||||||\r\n1110382|58839|06317|00|6880628175|01009601012116213536022571834|2021-05-19|1|13709.87|0.00|202105190110006880628175|2021-05-19 00:00:04|||勐阁|150402********243*|621700*********0749|13664769255|||1110382|70.16|32.90|2021-05-19 00:00:02|2021-05-19 00:00:05\r\n1110382|58839|06317|00|6880628175|01009601012116213536022571834|2021-05-19|1|13709.87|0.00|202105190110006880628175|2021-05-19 00:00:04|||勐阁|150402********243*|621700*********0749|13664769255|||1243831|13637.06|0.00|2021-05-19 00:00:02|2021-05-19 00:00:05\r\n1110382|58839|06317|00|6880628175|01009601012116213536022571834|2021-05-19|1|13709.87|0.00|202105190110006880628175|2021-05-19 00:00:04|||勐阁|150402********243*|621700*********0749|13664769255|||1243849|2.65|0.00|2021-05-19 00:00:02|2021-05-19 00:00:05\r\n1110382|58839|06317|00|6880628175|01009601012116213536022571834|2021-05-19|1|70.16|32.90|202105190110006880628175|2021-05-19 00:00:04|||勐阁|150402********243*|621700*********0749|13664769255|||1110382|70.16|32.90|2021-05-19 00:00:02|2021-05-19 00:00:05";
        File files = new File("/Users/liuhao/Downloads/workspake/ThreadLearn/src/util/111");
        OutputStream outputStream = new FileOutputStream(files);
        outputStream.write(s.getBytes(StandardCharsets.UTF_8));
        System.out.println("result");
        String checkKey = "1234";
        checkKey = checkKey.substring(0,checkKey.length()-1);
        System.out.println(checkKey);
        String [] keys  = {"22","33","44"};
        String [] contentKey  = {"33","44"};
        List<String> collect = Arrays.stream(keys).filter((k) -> Arrays.stream(contentKey).noneMatch((item) -> item.equals(k))).collect(Collectors.toList());
        System.out.println(collect);
    }
}
