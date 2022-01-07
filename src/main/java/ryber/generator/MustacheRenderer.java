package ryber.generator;


import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;


public class MustacheRenderer {
    private MustacheFactory mustacheFactory = new DefaultMustacheFactory(new File("./source"));

    public String render(Object model, String layout) {

        Mustache mustache = this.mustacheFactory.compile(layout);
        StringWriter stringWriter = new StringWriter();

        try {
            mustache.execute(stringWriter, model).close();
        } catch (IOException var6) {
            throw new RuntimeException(var6);
        }

        return stringWriter.toString();
    }
}