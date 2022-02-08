package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lixin
 * @date: 2022/1/4 9:41 обнГ
 * @description:
 */
public class LeetCode524 {


    public String findLongestWord(String s, List<String> dictionary) {

        dictionary = dictionary.stream().sorted().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList());

        for (String str : dictionary) {
            int p1 = 0, p2 = 0;

            while (p1 < s.length() && p2 < str.length()) {
                if (s.charAt(p1) == str.charAt(p2)) {
                    p1++;
                    p2++;
                } else {
                    p1++;
                }
            }
            if (p2 == str.length()) {
                return str;
            }

        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode524().findLongestWord("abpcplea", Arrays.asList("ale", "ble", "bcla", "apple", "monkey", "plea")));
    }

}
