package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LX
 * @Date 2020/7/22 19:54
 * @Description ��󵥴ʳ��ȳ˻�
 * ����: ["abcw","baz","foo","bar","xtfn","abcdef"] ���: 16  ����: ����������Ϊ "abcw", "xtfn"��
 * ����: ["a","aa","aaa","aaaa"]  ���: 0  ����: �������������������ʡ�
 * ������������ƣ�
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
