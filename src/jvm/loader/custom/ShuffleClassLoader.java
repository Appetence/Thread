package jvm.loader.custom;

import java.io.*;

/**
 * @program: ThreadLearn
 * @description:
 * @author: xiamu
 * @create: 2021-03-22 19:47
 */
public class ShuffleClassLoader extends ClassLoader {
    private static int mask = 0xff;

    private boolean compile(String fileStub) throws IOException {
        Process p = Runtime.getRuntime().exec("javac " + fileStub + ".java");
        try {
            p.waitFor();
        } catch (InterruptedException ie) {
            System.out.println(ie);
        }
        int ret = p.exitValue();
        if (ret == 0) {
            File file = new File(fileStub + ".class");
            FileInputStream fin = new FileInputStream(file);
            FileOutputStream fout = new FileOutputStream(fileStub + "_sec.class");
            int temp = -1;
            while ((temp = fin.read()) != -1) {
                temp = temp ^ mask;
                fout.write(temp);
            }
            fin.close();
            fout.close();
            file.delete();
            new File(fileStub + "_sec.class").renameTo(file);
        }
        return ret == 0;
    }

    private byte[] read(String fileStub) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (FileInputStream fin = new FileInputStream(fileStub + ".class")) {
            int temp = -1;
            while ((temp = fin.read()) != -1) {
                temp = temp ^ mask;
                bos.write(temp);
            }
            return bos.toByteArray();
        }
    }


    public Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        String fileStub = name.replace(".", "/");
        String javaFileName = fileStub + ".java";
        String classFileName = fileStub + ".class";
        InputStream isJava = this.getResourceAsStream(javaFileName.toString());
        InputStream isClass = this.getResourceAsStream(classFileName.toString());
        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);
        if (javaFile.exists() && (!classFile.exists()
                || javaFile.lastModified() > classFile.lastModified())) {
            try {
                //调用compile()方法，得到.class文件
                if (!compile(fileStub) || !classFile.exists()) {
                    throw new ClassNotFoundException(javaFileName);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (classFile.exists()) {
            try {
                //调用read()方法，把二进制文件转换为字节数组
                byte[] raw = read(fileStub);
                //调用defineClass()方法，把字节数组转换为Class实例
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        if (clazz == null) {
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

}