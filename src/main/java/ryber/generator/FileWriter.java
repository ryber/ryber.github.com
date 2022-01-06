package ryber.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.PrintWriter;

public class FileWriter {
    private static Logger logger = LoggerFactory.getLogger(FileWriter.class);

    public static void write(String contents, File file)  {
        try {
            file.getParentFile().mkdirs();
            logger.info("Writing: " + file.getAbsolutePath());
            PrintWriter writer = new PrintWriter(file, "UTF-8");
            writer.write(contents);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
