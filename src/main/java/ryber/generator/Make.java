package ryber.generator;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Make {

    public static void main(String... args) {
        make();
    }

    public static void make() {
        try {
            List<Article> posts = getPosts();
            Blogs.write(posts);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private static List<Article> getPosts() throws Exception {
        List<Article> posts = new ArrayList<>();
        File p = new File("./source/_posts/");
        for(File post : p.listFiles()){
            if(post.getName().endsWith(".md") | post.getName().endsWith(".markdown")){
                posts.add(createPost(post));
            }
        }
        return posts;
    }

    private static Article createPost(File post) throws Exception {
        String content = Files.readString(post.toPath());
        return new Article(
                post.getName(),
                content
        );
    }
}
