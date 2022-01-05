package ryber.generator;

import org.joda.time.DateTime;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class Post {
    private final String rawPostName;
    private final String content;
    private final DateTime time;
    private final String name;

    public Post(String name, String content) {
        this.rawPostName = name;
        this.content = content;
        String[] parts = name.split("-");
        this.time = new DateTime(parseInt(parts[0]), parseInt(parts[1]), parseInt(parts[2]), 0, 0);
        this.name = Stream.of(parts).skip(3).collect(Collectors.joining("-"))
                .replace(".md","").replace(".markdown", "");
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
        return String.format("/%s/%s/%s/%s/",
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
        return getDirectory() + "/index.html";
    }
}
