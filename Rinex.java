import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/12/2 17:25
 */
public class Rinex {
    public static void main(String[] args) {
        String cmd="sh_setup -yr 2020 -doy 032";
        Runtime run = Runtime.getRuntime();
        //返回与当前 Java 应用程序相关的运行时对象
        try {
            Process p = run.exec(cmd);
            // 启动另一个进程来执行命令
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
            String lineStr;
            while ((lineStr = inBr.readLine()) != null){
                System.out.println(lineStr);
            }
            if (p.waitFor() != 0) {
                if (p.exitValue() == 1){
                    System.err.println("命令执行失败!");
                }
            }
            inBr.close();
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
