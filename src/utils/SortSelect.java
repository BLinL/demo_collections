package utils;

import java.util.Arrays;

/**
 * 选择排序
 *  从0位置开始找到最小值 放在 数组首部
 */
public class SortSelect {
    public static void main(String[] args) {
        int[] arr = new int[] {34,5,22,6,90,11};
        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //假设当前位置是最小值所在位置
            int minIndx = i;

            for (int j = i+1; j < arr.length; j++) {
                //如果找到更小的值则替换位置
                if(arr[j] < arr[minIndx]) {
                    minIndx  = j;
                }
            }

            //如果最小值已经不是当前位置则交换
            if(i != minIndx) {
                int temp = arr[i];
                arr[i] = arr[minIndx];
                arr[minIndx] = temp;
            }
        }
    }
}
