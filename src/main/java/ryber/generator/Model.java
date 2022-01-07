package ryber.generator;

import org.joda.time.DateTime;

import java.util.Collection;
import java.util.HashMap;

public class Model extends HashMap<String, Object> {
    public Model(Collection<Article> content){
        put("articles", content);
        put("today", new DateTime());
        put("layout", "blog-index");
        put("isIndex", true);
    }
}
