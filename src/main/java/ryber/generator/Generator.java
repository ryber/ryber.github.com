package ryber.generator;


import java.util.Map;

public class Generator {

    private static final Map<String, Runnable> commands = Map.of(
            "run", () -> Server.start(),
            "stop", () -> Server.stop(),
            "generate", () -> Make.make()
    );

    public static void main(String... args) {
        if(args.length == 0){
            System.out.println("No Command");
            return;
        }
        String command = args[0];
        commands.getOrDefault(command, () -> System.out.println(" Unknown: " + command)).run();
        return;
    }
}
