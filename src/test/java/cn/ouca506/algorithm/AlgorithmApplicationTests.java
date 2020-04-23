package cn.ouca506.algorithm;

import cn.ouca506.algorithm.core.BinarySearch;
import cn.ouca506.algorithm.core.DivideConquer;
import cn.ouca506.algorithm.core.KMP;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlgorithmApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testBinarySearch() {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("判断是否相等的次数最多是log以2为底" + arr.length + "的对数+1");
        System.out.println(binarySearch.search(arr, 17));
        System.out.println(binarySearch.recurSearch(arr, 17));
    }

    @Test
    void testDivideConquer() {
        DivideConquer divideConquer = new DivideConquer();
        divideConquer.hanoiTower(2, 'A', 'B', 'C');
        String str1 = "123123214231232131232143252523654756867658";
        String str2 = "7930627076857867854376834758638954685437695";
        divideConquer.multiply(str1, str2);
        divideConquer.add(str1, str2);
    }

    @Test
    void testKMP() {
        KMP kmp = new KMP();
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        System.out.println(kmp.force(str1, str2));
        System.out.println("暴力匹配次数：" + kmp.forceCount);
        System.out.println("------------------------");
        System.out.println(kmp.kmp(str1, str2));
        System.out.println("KMP匹配次数：" + kmp.kmpCount);
        System.out.println("------------------------");
        System.out.println(kmp.kmp2(str1, str2));
        System.out.println("KMP2匹配次数：" + kmp.kmpCount2);
    }

    @Test
    void testPrim() {

    }
}
