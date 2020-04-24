package cn.ouca506.algorithm.leetcode;

/**
 * 硬币
 * 给定数量不限的硬币，币值为25分、10分、5分和1分
 * 编写代码计算n分有几种表示法
 * (结果可能会很大，你需要将结果模上1000000007)
 * 动态规划、数学求解
 * @author windmill666
 * @date 2020/4/23 16:14
 */

public class Coin_1481 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,1,7,8,3};
        System.out.println(getCoin(arr, arr.length - 1));
        int[] opt = new int[arr.length];
        System.out.println(getCoinOpt(arr, opt));

        int n = 100;
        System.out.println(waysToChange(n));
    }

//    //数学方法——等差数列求解
//    private static int waysToChange(int n) {
//        int ans = 0;
//        int mod = 1000000007;
//        for (int i = 0; i <= n / 25; i++) {
//            int rest = n - i * 25;
//            int p = rest / 5;
//            int q = rest / 10;
//            ans = ans + (p + 1)*(q + 1) % mod - q*(q + 1) % mod;
//            ans %= mod;
//        }
//        return ans;
//    }

    //动态规划求解
    private static int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1,5,10,25};
        dp[0] = 1;
        //dp方程：dp[i] += dp[i - coin];
        for(int coin : coins) {
            for(int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

    //递归求解——相隔取硬币
    private static int getCoin(int[] arr, int index) {
        if (index == 0) {
            return arr[0];
        } else if (index == 1){
            return Math.max(arr[0], arr[1]);
        } else {
            //选arr[index] --> getCoinOpt(arr, index - 2) + arr[index]注意选择的硬币不相邻
            //不选arr[index] --> getCoinOpt(arr, index - 1)
            return Math.max(getCoin(arr, index - 2) + arr[index], getCoin(arr, index - 1));
        }
    }

    //动态规划求解——相隔取硬币
    private static int getCoinOpt(int[] arr, int[] opt) {
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int A = opt[i - 2] + arr[i];
            int B = opt[i - 1];
            opt[i] = Math.max(A,B);
        }
        return opt[opt.length - 1];
    }
}
