package other;

import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/20 1:04
 *
 * 3. 关键字过滤：
 *  输入字符串s1和s2，判断s1中是否顺序包含s2中所有字符（大小写敏感），如果否，输出s1，如果是，输出“不可描述”
 *
 * 例：输入ABCde，Ad，输出：不可描述
 *    输入ABCde，AA输出：ABCde
 *
 * 要求：不能使用字符相关的库函数
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if (s1.length() == 0 || s2.length() == 0) {
            return;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int i = 0;
        int j = 0;
        while (i < len1 && j < len2) {
            if (c1[i] == c2[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == len2) {
            System.out.println("不可描述");
        } else {
            System.out.println(s1);
        }
    }
}
