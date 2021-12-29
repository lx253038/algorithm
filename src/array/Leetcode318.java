package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LX
 * @Date 2020/7/22 19:54
 * @Description 最大单词长度乘积
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"] 输出: 16  解释: 这两个单词为 "abcw", "xtfn"。
 * 输入: ["a","aa","aaa","aaaa"]  输出: 0  解释: 不存在这样的两个单词。
 * （解答错误待完善）
 */
public class Leetcode318 {

    public static void main(String[] args) {
        System.out.println(new Leetcode318().maxProduct(new String[]{"eae","ea","aaf","bda","fcf","dc","ac","ce","cefde","dabae"}));
    }

    public int maxProduct(String[] words) {
        if (words == null || words.length < 2) return 0;
        Set[] setArr = new Set[words.length];

        int max=0, i = 0;
        for (String str : words) {

        }
        for (int j = 0; j < setArr.length - 1; j++) {
            for (int k = j + 1; k < setArr.length; k++) {
                Set tmpset = new HashSet(setArr[j]);
                if (tmpset.retainAll(setArr[k])&&tmpset.isEmpty()) {
                    max = Math.max(max, setArr[j].size() * setArr[k].size());
                }
            }

        }
        return max;
    }

}
