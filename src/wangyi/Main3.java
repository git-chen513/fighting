package wangyi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Baker.chen
 * @create 2020/8/13 23:57
 */
class Main3 {

    public static final void main (String[] args){
        Map<String ,Object> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        Map<String ,Object> map1 = new HashMap<>();
        map1.put("key1","value1");
        map1.put("key2","value2");

        // Map集合的value是List
        map.put("k1",list);
        // Map集合的value是Map
        map.put("k2",map1);

        System.out.println(((List)map.get("k1")).get(0));
        System.out.println(((Map)map.get("k2")).get("key1"));
    }
}
