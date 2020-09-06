package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alex
 * @version 1.0
 * @date 2020/9/4 11:33
 */
public class FindDuplicateFileinSystem0609 {
    public static void main(String[] args) {
        FindDuplicateFileinSystem0609 findDuplicateFileinSystem0609 = new FindDuplicateFileinSystem0609();
        String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(findDuplicateFileinSystem0609.findDuplicate(paths));
    }
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, Integer> contentMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        for (String path : paths){
            String[] pathFiles = path.split(" ");
            String rootPath = pathFiles[0];
            String[] files = new String[pathFiles.length-1];
            System.arraycopy(pathFiles,1,files,0,pathFiles.length-1);
            for (String file : files){
                String fileContext = file.substring(file.indexOf("(") + 1,file.indexOf(")"));
                String s = rootPath + "/" + file.substring(0, file.indexOf("("));
                if (contentMap.containsKey(fileContext)){
                    int arrayIndex = contentMap.get(fileContext);
                    result.get(arrayIndex).add(s);
                }else {
                    contentMap.put(fileContext,index);
                    List<String> tmp = new ArrayList<>();
                    tmp.add(s);
                    result.add(index++,tmp);
                }
            }
        }
        return result.stream().filter(p -> p.size()>1).collect(Collectors.toList());
    }
    public List<List<String>> findDuplicate2(String[] paths) {
        HashMap < String, List < String >> map = new HashMap < > ();
        for (String path: paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] nameCont = values[i].split("\\(");
                nameCont[1] = nameCont[1].replace(")", "");
                List < String > list = map.getOrDefault(nameCont[1], new ArrayList < String > ());
                list.add(values[0] + "/" + nameCont[0]);
                map.put(nameCont[1], list);
            }
        }
        List < List < String >> res = new ArrayList < > ();
        for (String key: map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }
        return res;
    }
}
