import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class task3_recent_log {
    public static void main(String []args) throws Exception{
        List<String> logfiles = Files.readAllLines(Paths.get("logs.txt"));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String recent_log = logfiles.stream()
                .max(Comparator.comparing(line -> {
                    String s = line.substring(1, 20);
                    return LocalDateTime.parse(s, dtf);
                }))
                .orElse("No logs found.");
        System.out.println("recent log: " + recent_log);
    }
}
