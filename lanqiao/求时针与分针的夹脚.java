/*
输入
输入包含多组测试数据。

第一行为测试数据的组数T（1 ≤ T ≤ 1000）

对于每组数据：

第一行包含三个整数h，m，s，表示给定时刻的时、分、秒（0 ≤ h ≤ 23，0 ≤ m ≤ 59，0 ≤ s ≤ 59）

第二行包含一个整数t，表示经过的秒数（0 ≤ t ≤ 1000000000）

输出
对于每组数据，输出时针与分针的夹角。四舍五⼊保留小数点后四位。
 */
import java.util.Scanner;

public class 求时针与分针的夹脚 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0){
            double h = scanner.nextInt() % 12;
            double m = scanner.nextInt();
            double s = scanner.nextInt();
            double t = scanner.nextInt();

            h += (t / 3600) % 12 + m /60 + s/3600;
            m += (t / 60) % 60 + s/60;
            s += t % 60;

            h *= 5;
            double n = Math.abs(h - m)/60 *360 ;
            System.out.println(String.format("%.4f",n));
        }
    }
}
