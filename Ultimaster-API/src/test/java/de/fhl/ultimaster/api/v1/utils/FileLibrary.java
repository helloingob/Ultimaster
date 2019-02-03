package de.fhl.ultimaster.api.v1.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import org.pmw.tinylog.Logger;

public class FileLibrary {

    public static String getFileContent(String filename) {
        ClassLoader classLoader = FileLibrary.class.getClassLoader();
        File file = new File(classLoader.getResource(filename).getFile());
        if (file.exists()) {
            try {
                return new String(Files.readAllBytes(file.toPath()));
            } catch (IOException e) {
                Logger.error(e);
            }
        }
        return null;
    }

    public static File getFile(String filename) {
        try {
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);
            if (inputStream != null) {
                File tempFile = File.createTempFile(String.valueOf(inputStream.hashCode()), ".tmp");
                tempFile.deleteOnExit();
                try (FileOutputStream out = new FileOutputStream(tempFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                return tempFile;
            }
        } catch (IOException e) {
            Logger.error(e);
        }
        return null;
    }

}
