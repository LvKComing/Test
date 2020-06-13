import java.util.*;

/**
 * Created by root on 2018/6/6.
 */
public class Test {

    public static void main(String args[]) {

        List<User> users = new ArrayList<>();

        User user = new User();
        user.setId("1");
        user.setCode("2");
        user.setName("aaaaa");
        users.add(user);

        user = new User();
        user.setId("1");
        user.setCode("2");
        user.setName("bbb");
        users.add(user);

        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < users.size(); i++) {

        }

    }

    public static void remove(List<User> lists){
        HashSet<User> hashSet=new HashSet<User>();
        //需要保留的字段
        for (int i = 0; i < lists.size(); i++) {
            String id = lists.get(i).getId();
            String code = lists.get(i).getCode();
            //重写组合并赋值
            User u=new User();
            u.setId(id);
            u.setCode(code);
            hashSet.add(u);
        }
        //添加到新的集合中
        List<User> list=new ArrayList<User>();
        list.clear();
        list.addAll(hashSet);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString()+"===");
        }
        for (User s : list) {
            System.out.println(s.getId());
            System.out.println(s.getCode());
            System.out.println(s.getName());
        }
    }

}
