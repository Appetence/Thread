package thread.thread0906;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2021-10-20 19:54
 */
public class GzTest {
    public static void main(String[] args) {
    /*    String inFileName = "/Users/liuhao/Desktop/qdp.mvfc_wj4th_xl_distr_dtl.20211019.000.00.i.dat.gz";
        String outFileName = inFileName+ ".gz";
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(inFileName));
        }catch (FileNotFoundException e) {
            System.out.println("Could not find the inFile..."+inFileName);
        }
        GZIPOutputStream out = null;
        try {
            out = new GZIPOutputStream(new FileOutputStream(outFileName));
        }catch (IOException e) {
            System.out.println("Could not find the outFile..."+outFileName);

        }
        byte[] buf = new byte[10240];
        int len = 0;
        try {
            while (((in.available()>10240)&& (in.read(buf)) > 0)) {
                out.write(buf);
            }
            len = in.available();
            in.read(buf, 0, len);
            out.write(buf, 0, len);
            in.close();
            System.out.println("Completing the GZIP file..."+outFileName);
            out.flush();
            out.close();
        }catch (IOException e) {

        }*/
      /*  String replace = "12163103132584121452\t_2088731819366765_WJWL".replace("\t", "");
        System.out.println(replace);
        try (
                BufferedInputStream fis = new BufferedInputStream(new FileInputStream("/Users/liuhao/Desktop/2088041187527560_20210908_结算明细.csv"));
//                BufferedReader reader = new BufferedReader(new InputStreamReader(fis, busi.getCharset()), RANGE)
                BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "utf-8"))
        ) {
            int lineNum = 1;
            StringBuilder handelContent = new StringBuilder();
            Map<String, String> beforeMap = new HashMap<>();
            String line = "";
            while (true) {
                line = reader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           *//* try {
                Files.deleteIfExists(tempFileDirPath);
            } catch (IOException e) {
                logger.error("delete file error ", e);
            }*//*
        }*/
//        String regex = "\\([^}]*\\)";
        /**
         * () --> 标记 一个子表达式 开始 和 结束 的位置。
         *
         * . --> 匹配除换行符 \n 之外的任何单字符。
         *
         * * --> 匹配前面的子表达式零次或者多次。
         *
         * ? --> 匹配前端的子表达式零次或者一次。
         */
        String regex = "\\((.*?)\\)";
        String content = "中信百信银行股份有限公司(2088310139544224)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(content);
        if(matcher.find()){
            String group = matcher.group();
            System.out.print(group+";");
            String group1 = matcher.group(1);
            System.out.print(group1+";");
        }
        /*
        // 内容
        String value = "fileNameCode-->_AD2467524284sd234.json";

        // 匹配规则
        String reg = "_(.*?)\\.";
        Pattern pattern = Pattern.compile(reg);

        // 内容 与 匹配规则 的测试
        Matcher matcher = pattern.matcher(value);

        if( matcher.find() ){
            // 包含前后的两个字符
            System.out.println(matcher.group());
            // 不包含前后的两个字符
            System.out.println( matcher.group(1) );
        }else{
            System.out.println(" 没有匹配到内容....");
        }*/
    }




}
