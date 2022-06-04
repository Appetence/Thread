package jvm.loader.custom;

import util.XorEncrpt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: ThreadLearn
 * @description: class 加密解密，在解密之前需要先同一加密
 * @author: xiamu
 * @create: 2021-03-11 16:54
 */
public class CustomAscClassLoader extends ClassLoader {

    private final static String FILE_EXT = ".class";


    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder(name.length() + 6);
        sb.append(name.replace('.', '/')).append(FILE_EXT);
        InputStream is = this.getResourceAsStream(sb.toString());
        if (is == null) {
            throw new ClassNotFoundException("Class not found" + sb);
        } else {
            Class var19;
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                buf = XorEncrpt.decryptBytes(is, baos);

                var19 = this.defineClass(name, buf, 0, buf.length);
            } catch (IOException var17) {
                throw new ClassNotFoundException(name, var17);
            } catch (Exception e) {
                throw new ClassNotFoundException(name, e);
            } finally {
                try {
                    is.close();
                } catch (IOException var16) {
                }

            }

            return var19;
        }
    }
}
