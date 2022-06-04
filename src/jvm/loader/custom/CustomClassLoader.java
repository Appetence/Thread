package jvm.loader.custom;

import util.XorEncrpt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-11 16:54
 */
public class CustomClassLoader extends ClassLoader {

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

                int len;
                while ((len = is.read(buf)) >= 0) {
                    baos.write(buf, 0, len);
                }

                buf = baos.toByteArray();
                var19 = this.defineClass(name, buf, 0, buf.length);
            } catch (IOException var17) {
                throw new ClassNotFoundException(name, var17);
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
