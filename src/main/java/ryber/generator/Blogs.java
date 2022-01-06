package ryber.generator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Blogs {
    private static final Logger logs = LoggerFactory.getLogger(Blogs.class);
    private static final Path base = new File("./docs/blog/").toPath();
    private static final MustacheRenderer stache = new MustacheRenderer();

    public static void write(List<Article> posts) throws Exception {
        Collections.sort(posts, Comparator.comparing(Article::getTime));
        for(Article p : posts){
            writeOnepost(p);
        }

        writeFrontPage(posts.stream().limit(10).collect(Collectors.toList()));
    }

    private static void writeFrontPage(List<Article> collect) {
        File postFile = new File("./docs/index.html");
        String page = render(collect);
        FileWriter.write(page, postFile);
    }

    private static void writeOnepost(Article p) {
        File postFile = new File(base + p.getLink());
        String post = render(Arrays.asList(p));
        if(postFile.exists()){
            logs.info("update file: " + postFile);
        } else {
            logs.info("new file: " + postFile);
        }
        FileWriter.write(post, postFile);
    }

    private static String render(Collection<Article> article) {
        return stache.render(new Model(article), "layouts/main.mustache");
    }
}
