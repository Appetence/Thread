package thread.thread0906;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-09-06 20:13
 */
public class JSONTest {

    public static volatile ConcurrentHashMap<String, String> map1 = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();


    public static void main(String[] args) throws InterruptedException, IOException {
        String s = "1\u001B1000.00\u001B2021-06-16\u001B2021-06-16";
        String substring = s.substring(1, 2);
        boolean equals = substring.equals("\u001B");
        System.out.println(substring);
        String[] s2 = s.split("");
        String s1 = String.valueOf((char) 27);

        byte[] buffer = new byte[1024];
        File file = new File("/Users/liuhao/Desktop/qdp.mvfc_wj4th_xl_distr_dtl.20210616.000.00.i.dat.gz");
        if (file.exists()) {

            String unZipPath = "/Users/liuhao/Desktop/111qdp.mvfc_wj4th_xl_distr_dtl.20210616.000.00.i.dat";
            if (file.exists()) {
                try (
                        InputStream inputStream = new GZIPInputStream(new FileInputStream(file));
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ) {
                    int length = 0;
                    while ((length = inputStream.read(buffer)) != -1) {
                        bos.write(buffer, 0, length);
                    }
                    saveBytes(unZipPath, bos.toString().getBytes());
                } catch (Exception e) {
                    throw new RuntimeException("下载gz文件失败", e);
                }
            } else {
            }

        }

    }

    public static String saveBytes(String filePath, byte[] content) {
        try {
            FileChannel fc = new RandomAccessFile(filePath, "rw").getChannel();
            long length = fc.size();  //有来设置映射区域的开始位置
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, length, content.length);
            mbb.put(content);
            return filePath;
        } catch (IOException e) {
        }
        return null;
    }
}