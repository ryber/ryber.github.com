package ryber.generator;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "checksum", mixinStandardHelpOptions = true, version = "checksum 4.0",
        description = "Prints the checksum (MD5 by default) of a file to STDOUT.")
public class Generator implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return null;
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Generator()).execute(args);
        System.exit(exitCode);
    }
}
