package array;

import java.util.Arrays;

/**
 * @author LX
 * @date 2018/10/31 9:55
 */

/*����һ����СΪ n �����飬�ҵ����е�������������ָ�������г��ִ������� ? n/2 ? ��Ԫ�ء�
        ����Լ��������Ƿǿյģ����Ҹ������������Ǵ���������
        ʾ�� 1:����: [3,2,3]���: 3
        ʾ�� 2:����: [2,2,1,1,1,2,2]���: 2
*/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        //map��¼���ִ���
/*        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        int result=0;
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
                if(map.get(nums[i])>max){
                    max=map.get(nums[i]);
                    result =nums[i];
                }
            }else {
                map.put(nums[i],1);
                if(map.get(nums[i])>max){
                    max=map.get(nums[i]);
                    result =nums[i];
                }
            }

        }
        return result;*/
        //��������Ԫ�����򣬷����м��Ԫ��
        Arrays.sort(nums);
        return nums[nums.length / 2];


    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int i = me.majorityElement(new int[]{2, 2, 6, 9, 10, 2, 2});
        System.out.println(i);
    }
}
