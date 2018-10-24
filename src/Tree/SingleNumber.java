package Tree;

/*����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
˵��������㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
ʾ�� 1: ����: [2,2,1] ���: 1
ʾ�� 2: ����: [4,1,2,1,2] ���: 4
*/

public class SingleNumber {

    public int oneNumber(int[] nums) {
        //���ʽ  a ^ b ^ a=b;(��������)
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }
        return temp;
        //��ϣ��ʽ
        /*Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            if(!map.containsKey(i)){
                map.put(i,1);
            }else{
                map.remove(i);
            }
        }
        return map.entrySet().iterator().next().getKey();*/
    }


    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();

        int i = singleNumber.oneNumber(new int[]{1, 2, 1, 4, 2});
        System.out.println(i);
    }
}
