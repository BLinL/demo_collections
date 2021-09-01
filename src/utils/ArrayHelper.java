package utils;

import java.util.Arrays;

public class ArrayHelper {
    public static void main(String[] args) {
        int[] arr= new int[]{1,2,3, 5,6,7,8,9};
        System.out.println(sum(arr));
    }

    public static int sum(int[] arr){
        int sum;
        if(arr.length == 0){
            return 0;
        }else if(arr.length == 1){
            return arr[0];
        }
        sum = arr[0] + sum(Arrays.copyOf(arr, arr.length -1));

        return sum;
    }
}
