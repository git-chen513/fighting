package tengxun;

import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/23 21:23
 *
 * 数字之和
 *
 * case通过50%，超时
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            System.out.println(getMax(arr[i]));
        }
    }

    public static int getMax(int val) {
        int max = 0;
        for (int i = 0; i <= val; i++) {
            int x = i;
            int y = val - x;
            int sum1 = 0;
            int sum2 = 0;
            while (x > 0) {
                sum1 += x % 10;
                x = x / 10;
            }
            while (y > 0) {
                sum2 += y % 10;
                y = y / 10;
            }
            if ((sum1 + sum2) > max) {
                max = sum1 + sum2;
            }
        }
        return max;
    }
}
