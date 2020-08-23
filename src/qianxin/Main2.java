package qianxin;

import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/16 16:49
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        String temp = "";
        int x = 0;
        for (int i = 0; i < str.length; i++) {
            if ("undo".equals(str[i])) {
                temp = str[i-1];
                x = i-1;
                str[i-1] = "";
            } else if ("redo".equals(str[i])) {
                str[x] = temp;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        System.out.println(sb.toString());
    }
}
