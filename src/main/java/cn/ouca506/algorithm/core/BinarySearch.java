package cn.ouca506.algorithm.core;

/**
 * 二分查找算法
 * @author windmill666
 * @date 2020/4/21 17:22
 */

public class BinarySearch {

    public int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int middle;
        while (left <= right) {
            System.out.println("非递归判断");
            middle = (left + right)/2;
            if (key == arr[middle]) {
                return middle;
            } else if (key < arr[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public int recurSearch(int[] arr, int key) {
        return recur(arr, key, 0, arr.length - 1);
    }

    private int recur(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        System.out.println("递归判断");
        int middle = (left + right) / 2;
        if (key == arr[middle]) {
            return middle;
        } else if (key < arr[middle]) {
            return recur(arr, key, left, middle - 1);
        } else {
            return recur(arr, key ,middle + 1, right);
        }
    }
}
