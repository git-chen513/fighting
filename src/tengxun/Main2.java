package tengxun;

import java.util.*;

/**
 * @Author Baker.chen
 * @create 2020/8/23 21:03
 *
 * 第K小子串
 *
 * case通过5%，超出了限制的内存
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        List<String> list = getSubstrings(s);
        System.out.println(list.get(n-1));
    }

    public static List<String> getSubstrings(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                list.add(s.substring(i,j));
            }
        }
        return list;
    }
}
