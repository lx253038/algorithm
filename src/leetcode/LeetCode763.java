package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lixin
 * @date: 2021/12/20 8:47 обнГ
 * @description:
 */
public class LeetCode763 {


    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }

        List<Integer> resList = new ArrayList<>();
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            endIndex = Math.max(endIndex, arr[s.charAt(i) - 'a']);
            if (endIndex == i) {
                resList.add(endIndex - startIndex + 1);
                startIndex = endIndex + 1;
            }
        }
        return resList;
    }

}
