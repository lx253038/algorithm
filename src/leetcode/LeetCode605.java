package leetcode;

/**
 * @author: lixin
 * @date: 2021/12/13 8:53 обнГ
 * @description:
 */
public class LeetCode605 {


    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            if (n == 0) {
                return true;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode605().canPlaceFlowers(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 0));
    }
}
