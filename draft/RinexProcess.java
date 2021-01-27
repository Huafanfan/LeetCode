package draft;

import java.io.File;

/**
 * @author Alex
 * @version 1.0
 * @date 2021/1/24 13:51
 */
public class RinexProcess {
    public static void main(String[] args) {
        String cmd;
        String rinexPath = "/root/gamit/rinex2016/rinex";
        File rinexDic = new File(rinexPath);
        String[] files = rinexDic.list();
        for (String file : files) {
            File tempFile = new File(rinexPath + "/" + file);
            if (tempFile.getName().endsWith(".gz")) {
                cmd = rinexPath + "/crx2rnx " + tempFile.getAbsolutePath();
                executeCmd(cmd);
                //cmd = "rm -f " + tempFile.getAbsolutePath().replace(".gz","");
                //executeCmd(cmd);
            }
        }
    }

    public static boolean executeCmd(String cmd) {
        return executeCmd(cmd, null, null);
    }
    public static boolean executeCmd(String cmd, String[] envp, File dir) {
        Runtime run = Runtime.getRuntime();
        try {
            Process p = run.exec(cmd, envp, dir);
            if (p.waitFor() != 0) {
                if (p.exitValue() == 0){
                    return false;
                }
            }
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
