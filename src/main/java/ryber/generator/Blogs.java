package ryber.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Blogs {
    private static final Logger logs = LoggerFactory.getLogger(Blogs.class);
    private static final Path base = new File("./docs/blog/").toPath();
    private static final MustacheRenderer stache = new MustacheRenderer();

    public static void write(List<Article> posts) throws Exception {
        for(Article p : posts){
            write(p);
        }
    }

    private static void write(Article p) {
        File postFile = new File(base + p.getLink());
        String post = render(p);
        if(postFile.exists()){
            logs.info("update file: " + postFile);
        } else {
            logs.info("new file: " + postFile);
        }
        FileWriter.write(post, postFile);
    }

    private static String render(Article article) {
        return stache.render(new Model(Arrays.asList(article)), "layouts/main.mustache");
    }
}
