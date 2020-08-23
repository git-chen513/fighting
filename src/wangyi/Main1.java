package wangyi;

import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/12 19:51
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [][] str = new String[n][7];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 7; j++) {
                str[i][j] = sc.next();
            }
        }

        int countT = 0;
        int countB = 0;
        int countW = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 7; j++) {
                if (str[i][j].charAt(1) == 'T') {
                    countT++;
                } else if (str[i][j].charAt(1) == 'B') {
                    countB++;
                } else {
                    countW++;
                }
            }
            if (countT > 3 || countB > 3 || countW > 3) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
            countT = 0;
            countB = 0;
            countW = 0;
        }
    }
}
