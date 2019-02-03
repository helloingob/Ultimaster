package de.fhl.ultimaster.shared.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.pmw.tinylog.Logger;

public class FileHelper {

    public byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        FileInputStream fis = null;
        try {
            File f = new File(file);
            fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    Logger.error(e);
                }
            }
        }
        return bos != null ? bos.toByteArray() : null;
    }

}
