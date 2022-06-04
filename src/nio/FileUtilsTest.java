package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @program: ThreadLearn
 * @description:
 * @author: liuhao
 * @date: 2021-12-14 15:51
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        String path = "/Users/liuhao/Downloads/workspake/ThreadLearn/src/nio/aa";
        StringBuilder cont = new StringBuilder();

        createFileAndSaveContent(Paths.get(path), cont.toString().getBytes());
        System.out.println(">>>>>");
    }

    public static Path createFileAndSaveContent(Path filePath, byte[] content) {
        try {
            Path path = Files.createFile(filePath);
            Files.write(path, content);
        } catch (IOException e) {
            System.out.println("创建文件并写出内容，文件操作异常" + e);
        }
        return filePath;
    }
}
