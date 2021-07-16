package byteDance;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0,new StringBuilder(), res);
        return res;
    }
    public void dfs(String s, int index, int part,StringBuilder path, List<String> res){
        if (part > 4 || (part == 4 && index < s.length()) || (index == s.length() && part !=4) ){
            return;
        }
        if (index == s.length() && part == 4){
            res.add(path.delete(path.length()-1, path.length()).toString());
            return;
        }
        if (s.charAt(index) == '0'){
            path.append(0).append(".");
            part++;
            dfs(s, index+1, part, path, res);
        }
        else {
            for (int i=index; i<index + 3 && i < s.length(); i++){
                int num = Integer.parseInt(s.substring(index, i+1));
                if (num >= 1 && num <= 255){
                    int len = path.length();
                    path.append(num).append(".");
                    part++;
                    dfs(s, i + 1, part, path, res);
                    part--;
                    path.delete(len, path.length());
                }
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("101023"));
    }
}
