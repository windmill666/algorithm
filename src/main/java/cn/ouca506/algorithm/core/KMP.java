package cn.ouca506.algorithm.core;

import java.util.Arrays;

/**
 * 字符串匹配算法
 * @author windmill666
 * @date 2020/4/22 16:35
 */

public class KMP {

    public int forceCount;
    public int kmpCount;
    public int kmpCount2;

    public int force(String str1, String str2) {
        char[] string = str1.toCharArray();
        char[] patter = str2.toCharArray();
        int index;
        for (int i = 0; i < string.length; i++) {
            index = 0;
            while (index < patter.length && i < string.length) {
                forceCount++;
                if (string[i] != patter[index]) {
                    i = i - index;//退回到原来的位置
                    break;
                } else {
                    i++;
                    index++;
                }
            }
            if (index == patter.length) {
                System.out.println("匹配成功");
                return i - index;
            }
        }
        return -1;
    }

    public int kmp(String str1, String str2) {
        char[] string = str1.toCharArray();
        char[] patter = str2.toCharArray();
        int[] next = getNext(str2);
        System.out.println(Arrays.toString(next));
        int i = 0;
        int index = 0;
        while (index < patter.length && i < string.length) {
            kmpCount++;
            if (string[i] != patter[index]) {
                if (next[index] == -1) {
                    index = 0;
                } else {
                    index = next[index];
                }
            } else {
                index++;
            }
            i++;
        }
        if (index == patter.length) {
            System.out.println("匹配成功");
            return i - index;
        }
        return -1;
    }

    public int kmp2(String str1, String str2) {
        char[] string = str1.toCharArray();
        char[] patter = str2.toCharArray();
        int[] next = getNext2(str2);
        System.out.println(Arrays.toString(next));
        int i = 0;
        int index = 0;
        while (index < patter.length && i < string.length) {
            kmpCount2++;
            if (index > 0 && string[i] != patter[index]) {
                index = next[index - 1];
            }
            if (index == 0 && string[i] != patter[index]) {
                index++;
                i++;
            }
            if (string[i] == patter[index]) {
                index++;
                i++;
            }
        }
        if (index == patter.length) {
            System.out.println("匹配成功");
            return i - index;
        }
//        for (int i = 0, index = 0; i < string.length; i++) {
//            kmpCount2++;
//            while (index > 0 && string[i] != patter[index]) {
//                index = next[index - 1];
//            }
//            if (string[i] == patter[index]) {
//                index++;
//            }
//            if (index == patter.length) {
//                System.out.println("匹配成功");
//                return i - index + 1;
//            }
//        }
        return -1;
    }

    private int[] getNext(String patter) {
        char[] p = patter.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;//上来就不匹配，没有下一跳，所以填入-1，等使用时，把patter重新在0处匹配即可
        int i = 0;
        int j = -1;
        while (i < p.length - 1) {
            if (j == -1 || p[i] == p[j]) {//一直回溯，直到j=-1，说明与第一个都不相同，所以将j++后的0赋值给next
                i++;
                j++;
                next[i] = j;//将前缀j最大长度存储到i++位置
            } else {
                j = next[j];//j往前回溯，回到已匹配的最大长度的位置，之前将j存储到next中了，先在取出来
            }
        }
        return next;
    }

    private int[] getNext2(String patter) {
        char[] p = patter.toCharArray();
        int[] next = new int[p.length];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < p.length; i++) {
            while (j > 0 && p[i] != p[j]) {//一直回溯，如果回溯到j=0就看第一个是否相同-go
                j = next[j - 1];
            }
            if (p[i] == p[j]) {
                j++;//go-如果相同就开始加一
            }
            next[i] = j;//go-如果不相同就是j=0，不管是0还是j++的结果都赋值给next
        }
        return next;
    }
}
