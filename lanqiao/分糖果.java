/*
有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：

    每个小朋友都把自己的糖果分一半给左手边的孩子。

    一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。

    反复进行这个游戏，直到所有小朋友的糖果数都相同为止。

    你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。

【格式要求】

    程序首先读入一个整数N(2<N<100)，表示小朋友的人数。
    接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）
    要求程序输出一个整数，表示老师需要补发的糖果数。

样例输入
3
2 2 4
样例输出：
4
 */
import java.util.Scanner;

public class 分糖果 {

    static int excessCandy = 0;
    public static void sendCandy(int arr[]){
        int[] arrs = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] /= 2;
            if ( i == arr.length - 1) {
                arrs[0] = arr[i];
            }else {
                arrs[i + 1] = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] += arrs[i];
        }
    }

    public static void TeacherGiveCandy(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0){
                arr[i]++;
                excessCandy++;
            }
        }
    }

    public static boolean isEqual(int[] arr){
        int x = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != x)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        while (!isEqual(arr)){
            sendCandy(arr);
            TeacherGiveCandy(arr);
        }
        System.out.println(excessCandy);
    }
}
