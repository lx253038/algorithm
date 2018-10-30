package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LX
 * @date 2018/10/30 14:58
 */
/*
����һ��ż�����ȵ����飬���в�ͬ�����ִ����Ų�ͬ������ǹ���ÿһ�����ִ���һ���ǹ�������Ҫ����Щ�ǹ�ƽ���ָ�һ���ܵܺ�һ�����á��������ÿ��Ի�õ�����ǹ�����������
        ʾ�� 1:
        ����: candies = [1,1,2,2,3,3]
        ���: 3
        ����: һ��������������ǹ���ÿһ�ֶ���������
        ���ŷ��䷽�������û��[1,2,3],�ܵ�Ҳ���[1,2,3]������ʹ���û���ǹ�����������ࡣ
        ʾ�� 2 :
        ����: candies = [1,1,2,3]
        ���: 2
        ����: ���û���ǹ�[2,3],�ܻܵ���ǹ�[1,1]�����������ֲ�ͬ���ǹ����ܵ�ֻ��һ�֡�����ʹ�����ÿ��Ի�õ��ǹ���������ࡣ
*/
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        int size = candies.length;
        for (int i = 0; i < size; i++) {
            set.add(candies[i]);
        }
        if (size / 2 >= set.size()) {
            return set.size();
        } else {
            return size / 2;
        }

    }

    public static void main(String[] args) {
        DistributeCandies dc = new DistributeCandies();
        int i = dc.distributeCandies(new int[]{1, 1, 2, 3, 4, 5});
        System.out.println(i);
    }
}
