package ryber.generator;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Make {

    private static final Parser parser = Parser.builder().build();
    private static final HtmlRenderer renderer = HtmlRenderer.builder().build();

    public static void main(String... args) {
        make();
    }

    public static void make() {
        try {
            List<Post> posts = getPosts();
            Blogs.write(posts);
        }catch (Exception e){

        }
    }

    private static List<Post> getPosts() throws Exception {
        List<Post> posts = new ArrayList<>();
        File p = new File("./source/_posts/");
        for(File post : p.listFiles()){
            if(post.getName().endsWith(".md") | post.getName().endsWith(".markdown")){
                posts.add(createPost(post));
            }
        }
        return posts;
    }

    private static Post createPost(File post) throws Exception {
        String content = Files.readString(post.toPath());
        return new Post(
                post.getName(),
                render(content)
        );
    }

    private static String render(String content) {
        Node document = parser.parse(content);
        return renderer.render(document);
    }
}
