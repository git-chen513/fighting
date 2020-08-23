package wangyi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/12 19:51
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] row;
        int[] col;

        while (n>0) {
            row = new int[n];
            col = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    row[i] += arr[i][j];
                    col[i] += arr[j][i];
                }
            }
            int x = 0;
            int y = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] > row[x]) {
                    x = i;
                }
                if (col[i] > col[y]) {
                    y = i;
                }
            }
            System.out.print(x+1 + " ");
            System.out.println(y+1);
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (i == x){
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (j == y) {
                        continue;
                    }
                    queue.offer(arr[i][j]);
                }
            }

            n--;
            int[][] newArr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newArr[i][j] = queue.poll();
                }
            }

            arr = newArr;
        }

    }
}
