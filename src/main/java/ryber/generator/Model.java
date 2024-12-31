package ryber.generator;

import org.joda.time.DateTime;

import java.util.HashMap;
import java.util.List;

public class Model extends HashMap<String, Object> {
    public Model(List<Article> content){
        put("articles", content);
        put("today", new DateTime());
        put("layout", "blog-index");
        put("isIndex", true);
        if(content.size() > 1){
            put("title", "Soylent Code");
            put("description", "Soylent Code Is People!");
            put("url", "https://ryber.github.io");
            put("image", "https://ryber.github.io/assets/images/me.jpeg");
        } else {
            var article = content.get(0);
            put("title", article.getTitle());
            put("description", article.getDescription());
            put("url", "https://ryber.github.io" + article.getLink());
            put("image", "https://ryber.github.io/" + article.getImage());
        }
    }
}
