package cn.ouca506.algorithm.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windmill666
 * @date 2020/4/24 17:35
 */

public class Fibonacci {

    private static int count1 = 0;
    private static int count2 = 0;

    public static void main(String[] args) {
        int n = 10;
        System.out.println(fib(10));//时间复杂度为O(2^n)
        System.out.println(count1);
        System.out.println(fib(1,1,n));//时间复杂度为O(n)
        System.out.println(count2);
        System.out.println(fib2(n));//时间复杂度为O(n)
    }

    //传统递归
    private static long fib(int n) {
        count1++;
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //优化递归
    private static long fib(long a, long b, int n) {
        count2++;
        if (n < 2) {
            return a;
        } else {
            return fib(b, a + b, n - 1);
        }
    }

    //非递归
    private static long fib2(int n) {
        List<Long> res = new ArrayList<>();
        res.add((long) 1);
        res.add((long) 1);
        for (int i = 2; i < n; i++) {
            res.add(res.get(i - 1) + res.get(i - 2));
        }
        return res.get(res.size() - 1);
    }

}
