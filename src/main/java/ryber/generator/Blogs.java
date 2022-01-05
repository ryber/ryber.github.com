package ryber.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class Blogs {
    private static final Logger logs = LoggerFactory.getLogger(Blogs.class);
    private static final Path base = new File("./docs/blog/").toPath();

    public static void write(List<Post> posts) throws Exception {
        for(Post p : posts){
            write(p);
        }
    }

    private static void write(Post p) {
        File dir = new File(base + p.getDirectory());
        dir.mkdirs();
        File postFile = new File(p.getLink());
        if(postFile.exists()){
            logs.info("update file: " + postFile);
        } else {
            logs.info("new file: " + postFile);
        }
    }
}
