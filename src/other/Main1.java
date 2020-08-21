package other;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/20 16:09
 *
 * 问题描述：
 *  一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 *  再落下，求它在第n次落地时，共经过多少米？第n次反弹多高？（n<=10）
 *
 * 输入描述：
 *  一行，一个整数n (1<=n<=10)
 *
 * 输出描述：
 *  输出两个浮点数ans1,ans2。ans1为第n次落地时，共经过的距离；
 *  ans2为第n次反弹的高度。答案应与标准答案误差小于1e-5。两个数间以空格相间。
 *
 * 示例1：
 *  输入：1
 *  输出：100.000000 50.000000
 *
 * 示例2：
 *  输入：10
 *  输出：299.609375 0.097656
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float result = 100;
        float sum = 100;
        for (int i = 0; i < n; i++) {
            result = result / 2;
            if (i != 0) {
                sum = sum + result * 2 * 2;
            }
        }
        DecimalFormat df = new DecimalFormat("0.000000");
        System.out.printf(df.format(sum) + " " + df.format(result));
    }
}
