package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileUtil {
    public static String copyFile(File source, String destDir, int userId) throws IOException {
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();
        String safeName = System.currentTimeMillis() + "_user" + userId + "_" + source.getName().replaceAll("\\s+", "_");
        File dest = new File(dir, safeName);
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return dest.getPath().replace("\\", "/");
    }
}
