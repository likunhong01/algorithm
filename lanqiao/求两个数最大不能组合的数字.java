/*
   小明开了一家糖果店。他别出心裁：把水果糖包成4颗一包和7颗一包的两种。糖果不能拆包卖。

    小朋友来买糖的时候，他就用这两种包装来组合。当然有些糖果数目是无法组合出来的，比如要买 10 颗糖。

    你可以用计算机测试一下，在这种包装情况下，最大不能买到的数量是17。大于17的任何数字都可以用4和7组合出来。

    本题的要求就是在已知两个包装的数量时，求最大不能组合出的数字。

输入：
两个正整数，表示每种包装中糖的颗数(都不多于1000)

要求输出：
一个正整数，表示最大不能买到的糖数

样例输入：
4 7
样例输出：
17

样例输入：
3 5
样例输出：
7
 */
import java.util.Scanner;

public class 求两个数最大不能组合的数字 {
    public static int g(byte[] data, int a) {
        int n=0;
        for (int i=0; i<data.length;i++) {
            if (data[i]==1) {
                n++;
                if(n>=a) return i-a;
            }
            else
                n=0;
        }
        return -1;
    }
    public static void f(int a, int b) {
        int N = 1000 * 100;
        byte[] data = new byte[N];
        for(int i=0; i<N/a; i++) {
            for(int j=0; j<(N-i*a)/b; j++) {
                if (i*a + j*b <N) data[i*a + j*b] = 1;
            }
        }
        System.out.println(g(data, a));
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        f(a,b);
    }
}