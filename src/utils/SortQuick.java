package utils;

import java.util.Arrays;


public final class SortQuick {
    public static void main(String[] args) {
        int[] arr = new int[]{34, 5, 22, 6, 90, 11};
        sort(arr, 0 , arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public final static void sort(int[] arr, int low, int high) {
        if(low < high) {
            // 基准值
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            int pi = i + 1;

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public final static int random(int len) {
        return (int) Math.floor(Math.random() * len);
    }
}
