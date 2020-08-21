package other;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/20 16:44
 *
 * 问题描述：
 *  小陆每天要写一份工作日报，日报标题含有日期。
 *  几年后，他翻开以前的日报，想知道两份日报的日期是否同为星期几，请编程帮助他判断。
 *
 * 输入描述：
 *  第一行一个正整数T(1<=T<=100)。表示有T个测试样例。
 *  接下来T行，每一行有6个正整数y1,m1,d1,y2,m2,d2,（以空格相间）。
 *  其中y1-m1-d1分别为第一个日期的年月日，
 *  y2-m2-d2分别为第二个日期的年月日。
 *  （满足1970<=y1,y2<=9999, 1<=m1,m2<=12, 1<=d1,d2<=31,且保证两个日期是合法的）。
 *
 *  输出描述：
 *      输出T行，对应T个答案。对于每一行，如果两个日期在同一星期几，输出“True”；
 *      否则输出“False”（输出内容不含双引号）。
 *
 *  示例：
 *      输入：2
 *          1970 1 2 2020 2 7
 *          2020 1 1 2020 1 2
 *      输出：True
 *           False
 *      说明：1970-1-2和2020-2-7同为星期五；
 *           2020-1-1为星期三，2020-1-2为星期四。
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


    }

    /**
     * 月份数组，表示对应的月份有多少天，要注意闰年的情况：闰年2月份有29天，非闰年2月份只有28天
     */
    public int[] months = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * 判断是否是闰年
     * @param year
     * @return
     */
    public boolean isLeapYear(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    /**
     * 计算给定的日期在这一年中属于第几天
     * @param y1 年
     * @param m1 月
     * @param d1 日
     * @return
     */
    public int YearDay(int y1, int m1 , int d1){
        int sumDay = 0;
        for (int j = 0; j < m1 - 1; j++){
            // 闰年，总日期加1
            if (j == 1 && isLeapYear(y1)) {
                sumDay += 1;
            }
            sumDay += months[j];
        }
        return sumDay + d1;
    }


    public int Main(int y1, int m1, int d1, int y2, int m2, int d2){
        // 表示第一个日期已走天数
        int sum1 = YearDay(y1, m1, d1);
        // 表示第二个日期已走天数
        int sum2 = YearDay(y2,m2,d2);
        //表示第一个日期到第二个日期的中间年份总天数
        int sum3 = 0;
        for (int i = y1; i < y2; i++) {
            sum3 += YearDay(i, months.length,31);
        }

        //sum3-sum1表示到第二个年份之前所走天数，加上第二个日期走的天数即可获得中间所有的天数
        int temp = (sum2 + sum3 - sum1) % 7;
        return (sum2 + sum3 - sum1) % 7;
    }
}
