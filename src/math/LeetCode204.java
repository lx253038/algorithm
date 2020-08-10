package math;

import java.util.Arrays;

/**
 * @Author LX
 * @Date 2020/7/28 21:32
 * @Description ͳ������С�ڷǸ����� n ��������������
 * ʾ��:
 * ����: 10
 * ���: 4
 * ����: С�� 10 ������һ���� 4 ��, ������ 2, 3, 5, 7 ��
 */
public class LeetCode204 {

    public static void main(String[] args) {
        System.out.println(new LeetCode204().countPrimes(10));
    }


    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            for (int j = i * 2; j < n; j = j + i) {
                isPrime[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }


}
