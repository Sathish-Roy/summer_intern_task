import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class task2_unique_logs {
    public static void main(String[] args) throws Exception {
        List<String> logfiles = Files.readAllLines(Paths.get("logs.txt"));
        Map<String, Long> log_levels = logfiles.stream()
                .map(line -> line.replaceAll(".*\\[(INFO|DEBUG|WARN|ERROR)]\\s.*", "$1"))
                .filter(level -> Arrays.asList("INFO", "DEBUG", "WARN", "ERROR").contains(level))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("count of log levels : ");
        log_levels.forEach((l, c) -> System.out.println(l + " : " + c));

    }
}
