package ryber.generator;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.util.Map;

public class Server {
    private static Javalin app;

    public static void main(String[] args){
        start();
    }

    public static void start() {
        app = Javalin.create(c -> {
            c.addStaticFiles(staticFiles -> {
                staticFiles.hostedPath = "/";                   // change to host files on a subpath, like '/assets'
                staticFiles.directory = "./docs";              // the directory where your files are located
                staticFiles.location = Location.EXTERNAL;      // Location.CLASSPATH (jar) or Location.EXTERNAL (file system)
                staticFiles.precompress = false;                // if the files should be pre-compressed and cached in memory (optimization)
                staticFiles.aliasCheck = null;                  // you can configure this to enable symlinks (= ContextHandler.ApproveAliases())
                staticFiles.headers = Map.of();              // headers that will be set for the files
                staticFiles.skipFileFunction = req -> false;
            });
        }).start(7777);
    }

    public static void stop(){
        if(app != null){
            app.stop();
        }
    }
}
