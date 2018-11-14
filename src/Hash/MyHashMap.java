package Hash;

import java.util.Map;

/**
 * @author LX
 * @date 2018-11-14 12:31
 */
/*��ʹ���κ��ڽ��Ĺ�ϣ������һ����ϣӳ��
        �����˵��������Ӧ�ð������µĹ��� put(key, value)�����ϣӳ���в���(��,ֵ)����ֵ�ԡ��������Ӧ��ֵ�Ѿ����ڣ��������ֵ��
        get(key)�����ظ����ļ�����Ӧ��ֵ�����ӳ���в����������������-1�� remove(key)�����ӳ���д����������ɾ�������ֵ�ԡ�
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // ���� 1
        hashMap.get(3);            // ���� -1 (δ�ҵ�)
        hashMap.put(2, 1);         // �������е�ֵ
        hashMap.get(2);            // ���� 1
        hashMap.remove(2);         // ɾ����Ϊ2������
        hashMap.get(2);            // ���� -1 (δ�ҵ�) */
public class MyHashMap {
    private Map<Integer, Integer> map; //ʹ��hashmap��ʽ

    private int vals[];


    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        vals = new int[1000000];
        for (int i = 0; i < 1000000; i++) {
            vals[i] = -1;
        }

    }

    /**
     * value will always be positive.
     */
    public void put(int key, int value) {
        vals[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return vals[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        vals[key] = -1;
    }
}