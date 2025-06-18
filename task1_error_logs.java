import java.nio.file.*;
public class task1_error_logs {
    public static void main(String []args) throws Exception{
        long error_count=Files.lines(Paths.get("logs.txt"))
                .filter(l->l.contains("[ERROR]")).count();
        System.out.println("the total logs containing the word 'ERROR' are = "+error_count);
    }
}
