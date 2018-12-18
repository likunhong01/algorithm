//快速排序
//划分成两个数组，通过递归给每一个子数组快速排序
//1.设定关键字，比关键字小的放在一边，大的放在另一边
//2.设置数组最右端为关键字
//3.递归实现快速排序
public class 快排 {
    public static void main(String[] args) {
        Integer[] arr = {5,6,4,3,2,1,16,22,0};
        System.out.print("排序前：");
        display(arr);
        System.out.print("排序后：");
        sort(arr,0, 8);
        display(arr);
    }
    public static <T extends Comparable<T>> void display(T[] arr){
        for (T t :arr) {
            System.out.print(t + ",");
        }
        System.out.println();
    }
    //划分数组
    public static <T extends Comparable<T>> int part(T[] arr , int left , int right , T point) {
        //两个指针
        int leftptr = left - 1;
        int rightptr = right;

        while(true) {
            //从最左和最右开始找，比point大的放右边，比point小的放左边
            while(leftptr < rightptr && arr[++leftptr].compareTo(point) < 0);
            while(leftptr < rightptr && arr[--rightptr].compareTo(point) > 0);

            //找到后交换，然后再继续找
            if(leftptr >= rightptr) {
                break;
            }
            else {//交换
                T tmp = arr[leftptr];
                arr[leftptr] = arr[rightptr];
                arr[rightptr] = tmp;
            }
        }
        //数组分割完毕，把关键字插入中间，leftptr和rightptr都是中间的了
        T tmp = arr[leftptr];
        arr[leftptr] = arr[right];
        arr[right] = tmp;

        //返回切入点位置
        return leftptr;
    }

    public static <T extends Comparable<T>> void sort(T[] arr , int left , int right) {
        if (right <= left) {
            return;
        }
        else {
            //设置最右为关键字
            T point = arr[right];
            //获得切入点同时划分
            int part = part(arr, left, right, point);
            //递归对左边数组排序
            sort(arr, left, part - 1);
            //右边排序
            sort(arr, part + 1, right);
        }
    }
}