package util;

import java.io.*;

/**
 * @program: ThreadLearn
 * @description: 加解密方法
 * @author: xiamu
 * @create: 2021-03-12 11:37
 */
public class XorEncrpt {
    //异或操作,可以进行加密和解密
    private static void xor(InputStream in, OutputStream out) throws Exception {
        int ch;
        while (-1 != (ch = in.read())) {
            ch = ch ^ 0xff;
            out.write(ch);
        }
    }
    private static void xorBytes(InputStream in, OutputStream out) throws Exception {
        int ch;
        while (-1 != (ch = in.read())) {
            ch = ch ^ 0xff;
            out.write(ch);
        }
    }

    //加密方法
    public static void encrypt(File src, File des) throws Exception {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(des);

        xor(in, out);

        in.close();
        out.close();
    }

    //解密方法
    public static byte[] decrypt(File src) throws Exception {
        InputStream in = new FileInputStream(src);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        xor(in, bos);
        byte[] data = bos.toByteArray();

        in.close();
        bos.close();
        return data;
    }
    public static byte[] decryptBytes(InputStream in, ByteArrayOutputStream bos) throws Exception {
        xor(in, bos);
        byte[] data = bos.toByteArray();

        in.close();
        bos.close();
        return data;
    }
/*
    public static void main(String[] args) throws Exception {
        File src = new File("F:\\UserSrc.class");
        File dest = new File("F:\\User.class");
        XorEncrpt xorEncrpt= new XorEncrpt();
        xorEncrpt.encrypt(src, dest);
    }*/
}
