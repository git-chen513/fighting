package qianxin;

import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/18 16:54
 *
 * 1. 老板发奖金
 *
 * 老板一共需要给某个员工发奖金n元，可以选择一次发1元，也可以选择1次发2元……老板也可以选择一次发n元
 * （必须以元为整数单位发放） 请问老板给这位员工发放完n元奖金共有多少种方法？
 *
 * 备注：输入为一个整数，输出也为一个整数
 *
 * 思路：这是青蛙跳台阶的升级版
 * 如果需要工资n元，总的发工资方法有f(n) = f(n-1)+f(n-2)+……+f(2)+f(1)+1
 * 如果需要工资n-1元，总的发工资方法有f(n-1) = f(n-2)+f(n-3)+……+f(2)+f(1)+1
 * 联合两式可以得到f(n) = 2 * f(n-1)
 */
public class Main1 {

    public static int count(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        } else {
            return 2 * count(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count(n));
    }
}
