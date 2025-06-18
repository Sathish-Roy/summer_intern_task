import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class task4_grouping_logs {
    public static void main(String []args) throws Exception{
        List<String> logfiles = Files.readAllLines(Paths.get("logs.txt"));
        Map<String, List<String>> logs = logfiles.stream()
                .collect(Collectors.groupingBy(line -> line.substring(1, 11)));
        System.out.println("Logs Grouped by Date:");
        logs.forEach((date, entries) ->
        {System.out.println(date + " => " + entries.size() + " logs");});
    }
}


