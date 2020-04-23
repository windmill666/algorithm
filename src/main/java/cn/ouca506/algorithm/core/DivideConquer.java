package cn.ouca506.algorithm.core;

/**
 * 分治算法
 * @author windmill666
 * @date 2020/4/22 7:18
 */

public class DivideConquer {

    public void hanoiTower(int n, char a, char b, char c) {
        //A B C
        if (n == 1) {
            System.out.println(1 + ": " + a + "=>" + c);
        } else {
            //把所有汉诺塔看成两部分组成：n和(n-1,n-2,...,1)
            //先把n-1个盘从第一个塔移动到中间塔
            hanoiTower(n - 1, a, c, b);//当hanoiTower(2,a,c,b)--[3:a,c]--hanoiTower(2,b,a,c)
            //再把n盘从第一个塔移动到第三个塔
            System.out.println(n + ": " + a + "=>" + c);
            //最后把n-1个盘从中间塔移动到第三个塔
            hanoiTower(n - 1, b, a, c);//当hanoiTower(2,b,a,c)这时b对应a，c对应b
        }
    }

    public void multiply(String a, String b) {
        int[] handleA = handle(a);
        int[] handleB = handle(b);

        int[] arr = multiply(handleA, handleB);

        System.out.println(print(arr));
    }

    public void add(String a, String b) {
        int[] handleA = handle(a);
        int[] handleB = handle(b);

        int[] arr = add(handleA, handleB);

        System.out.println(print(arr));
    }

    private int[] add(int[] handleA, int[] handleB) {
        int[] result = new int[Math.max(handleA.length, handleB.length) + 1];
        //先不处理进位
        int temp = handleA.length - handleB.length;
        int addB = 0;
        int addA = 0;
        for (int i = 1; i < result.length; i++) {
            if (temp > 0) {
                addA = handleA[i - 1];
                addB = (i - 1 < temp ? 0 : handleB[i - 1 - temp]);
            }
            if (temp < 0 ) {
                addA = (i - 1 < -temp ? 0 : handleA[i - 1 + temp]);
                addB = handleB[i - 1];
            }
            result[i] = addA + addB;
        }
        int carry = 0;//进位
        for (int i = result.length - 1; i > 0; i--) {
            result[i] += carry;
            carry = result[i] / 10;
            result[i] = result[i] % 10;
        }
        result[0] = carry;
        return result;
    }

    private int[] multiply(int[] handleA, int[] handleB) {
        int[] result = new int[handleA.length + handleB.length];
        //先不处理进位
        for (int i = 0; i < handleA.length; i++) {
            for (int j = 0; j < handleB.length; j++) {
                result[i + j + 1] += handleA[i] * handleB[j];
            }
        }
        int carry = 0;//进位
        for (int i = result.length - 1; i > 0; i--) {
            result[i] += carry;
            carry = result[i] / 10;
            result[i] = result[i] % 10;
        }
        result[0] = carry;
        return result;
    }

    private int[] handle(String str) {
        int[] handle = new int[str.length()];
        int index = 0;
        for (char v : str.toCharArray()) {
            handle[index++] = v - '0';
        }
        return handle;
    }

    private String print(int[] arr) {
        StringBuilder res = new StringBuilder();
        if (arr[0] != 0) {
            res.append(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            res.append(arr[i]);
        }
        return res.toString();
    }
}
