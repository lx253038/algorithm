package array;

/**
 * @Author LX
 * @Date 2020/8/11 19:15
 * @Description ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ����?(i,?ai) ���������ڻ� n ����ֱ�ߣ���ֱ�� i?�������˵�ֱ�Ϊ?(i,?ai) �� (i, 0)���ҳ����е������ߣ�ʹ��������?x?�Ṳͬ���ɵ�����������������ˮ��
 * ˵�����㲻����б��������?n?��ֵ����Ϊ 2��
 */
public class LeetCode11 {

    public static void main(String[] args) {
        System.out.println(new LeetCode11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left <= right) {
            max = Math.max((right - left) * Math.min(height[left], height[right]), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
