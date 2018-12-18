public class 冒泡 {
    public static void main(String[] args) {
        Integer[] arr = {5,6,4,3,2,1};
        System.out.print("排序前：");
        display(arr);
        System.out.print("排序后：");
        maopao(arr);
        display(arr);
    }
    public static <T extends Comparable<T>> void display(T[] arr){
        for (T t :arr) {
            System.out.print(t + ",");
        }
        System.out.println();
    }
    public static <T extends Comparable<T>> void maopao(T[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
