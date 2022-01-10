package ryber.generator;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Blogs {
    private static final Logger logs = LoggerFactory.getLogger(Blogs.class);
    private static final Path base = new File("./docs/").toPath();
    private static final MustacheRenderer stache = new MustacheRenderer();

    public static void write(List<Article> posts) throws Exception {
        Collections.sort(posts, Comparator.comparing(Article::getTime).reversed());
        for(Article p : posts){
            writeOnepost(p);
        }
        writePagedBlogs(posts);
        writeAtom(posts);
        writeArchive(posts);
    }

    private static void writeArchive(List<Article> posts) {
        Multimap<Integer, Article> grouped = HashMultimap.create();
        posts.forEach(p -> grouped.put(p.getTime().getYear(), p));
        List<Archive> archive = grouped.asMap()
                .entrySet()
                .stream()
                .map(e -> new Archive(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(Archive::getYear).reversed())
                .collect(Collectors.toList());

        String content = stache.render(Map.of("archives", archive,
                "isArchive", true), "layouts/main.mustache");
        FileWriter.write(content, new File("./docs/blog/archives/index.html"));
    }

    public static class Archive {
        private int year;
        private List<Article> articles;

        public Archive(int Year, Collection<Article> articles){
            year = Year;
            this.articles = Lists.newArrayList(articles);
            Collections.sort(this.articles, Comparator.comparing(Article::getTime).reversed());
        }


        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }

    private static void writePagedBlogs(List<Article> posts) {
        List<List<Article>> partition = Lists.partition(posts, 10);
        int no = 1;
        int toalPages = partition.size();

        for(List<Article> page : partition){
            if(no == 1) {
                writeListPage(page,
                        "./docs/index.html", 1, toalPages);
            }
            writeListPage(page, "./docs/blog/page/" + no + "/index.html", no, toalPages);
            no++;
        }
    }

    private static void writeListPage(List<Article> collect, String pathname, int pageNo, int totalPages) {
        File postFile = new File(pathname);
        Map<String, Object> paging = new HashMap<>();
        paging.put("hasPaging", true);
        if(pageNo < totalPages){
            paging.put("older", pageNo + 1);
        }
        if(pageNo > 1) {
            paging.put("newer", pageNo - 1);
        }
        String page = render(collect, paging);
        FileWriter.write(page, postFile);
    }

    private static void writeAtom(List<Article> posts) {
        File postFile = new File("./docs/atom.xml");
        String page = stache.render(new Model(posts), "layouts/atom.mustache");
        FileWriter.write(page, postFile);
    }

    private static void writeOnepost(Article p) {
        File postFile = new File(base + p.getLink() + "index.html");
        String post = render(Arrays.asList(p));
        if(postFile.exists()){
            logs.info("update file: " + postFile);
        } else {
            logs.info("new file: " + postFile);
        }
        FileWriter.write(post, postFile);
    }

    private static String render(Collection<Article> article){
        return render(article, Map.of());
    }

    private static String render(Collection<Article> article, Map<String, Object> data) {
        Model model = new Model(article);
        model.putAll(data);
        return stache.render(model, "layouts/main.mustache");
    }
}
