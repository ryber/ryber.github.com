package ryber.generator;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Article {
    private static final Parser parser = Parser.builder().build();
    private static final HtmlRenderer renderer = HtmlRenderer.builder().build();

    private final String rawPostName;
    private final String content;
    private final DateTime time;
    private final String name;
    private final String title;

    public Article(String name, String content) {
        this.rawPostName = name;
        String[] parts = name.split("-");
        this.time = new DateTime(parseInt(parts[0]), parseInt(parts[1]), parseInt(parts[2]), 0, 0);
        this.name = Stream.of(parts).skip(3).collect(Collectors.joining("-"))
                .replace(".md","").replace(".markdown", "");
        String[] page = content.trim().split("---");
        String[] headers = page[1].split("\n");
        this.title = tryFind("title", headers, name.replace("-", ""));
        this.content = render(page[2]);
    }

    private static String render(String content) {
        Node document = parser.parse(content);
        return renderer.render(document);
    }

    private String tryFind(String thing, String[] header, String defValue) {
        for(String h : header){
            if(h.toLowerCase().startsWith(thing)){
                return h.replace(thing + ":", "")
                        .replace("\"","").trim();
            }
        }
        return defValue;
    }

    public String getFormattedDate(){
        return  DateTimeFormat.mediumDate().print(time);
    }

    public String getRawPostName() {
        return rawPostName;
    }

    public String getContent() {
        return content;
    }

    public DateTime getTime() {
        return time;
    }

    public String getDirectory() {
        return String.format("/blog/%s/%s/%s/%s",
                time.getYear(), pad(time.getMonthOfYear()), pad(time.getDayOfMonth()), name);
    }

    private String pad(int d) {
        if(d < 10){
            return "0" + d;
        }
        return String.valueOf(d);
    }

    public String getName() {
        return name;
    }

    public String getLink() {
        return getDirectory() + "/";
    }

    public String getTitle() {
        return title;
    }
}
