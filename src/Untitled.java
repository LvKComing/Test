import java.util.*;
import java.util.regex.*;

class Untitled {
    private static String getV(String input, String key) {
        String reg = "([\"\']?)" + key + "\\1[:\\s]+([\"\']?)([^\"\']*)\\2";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(input);
        while (m.find()) {
            return m.group(3);
        }
        return "";
    }

    public static void main(String[] args) {
        String list1 = "{\"id\":\"1\",\"name\":\"张三\",\"subject\":\"数学\",\"fen\":\"80\"}";
        String list2 = "{\"id\":\"1\",\"name\":\"张三\",\"subject\":\"语文\",\"fen\":\"90\"}";
        String list3 = "{\"id\":\"2\",\"name\":\"张三\",\"subject\":\"数学\",\"fen\":\"60\"}";
        String list4 = "{\"id\":\"1\",\"name\":\"李四\",\"subject\":\"数学\",\"fen\":\"80\"}";


        String[] arr = {list1, list2, list3, list4};
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < arr.length; i++) {
            String ai = arr[i];
            String id = getV(ai, "id");
            String name = getV(ai, "name");
            String key = id + name;
            if (null == map.get(key)) {
                map.put(key, ai);
            } else {
                String prev = map.get(key);
                String subject1 = getV(prev, "subject");
                String fen1 = getV(prev, "fen");
                String subject2 = getV(ai, "subject");
                String fen2 = getV(ai, "fen");

                String s1 = "\"subject\":" + subject1 + "," + subject2 + "\"";
                String f1 = "\"fen\":" + fen1 + "," + fen2 + "\"";
                prev = prev.replaceAll("([\"\']?)subject\\1[:\\s]+([\"\']?)([^\"\']*)\\2", s1)
                        .replaceAll("([\"\']?)fen\\1[:\\s]+([\"\']?)([^\"\']*)\\2", f1);
                map.put(key, prev);
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}