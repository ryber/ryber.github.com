package ryber.generator;

import java.util.Collection;
import java.util.HashMap;

public class Model extends HashMap<String, Object> {
    public Model(Collection<Article> content){
        put("articles", content);
    }
}
