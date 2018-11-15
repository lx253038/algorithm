package Hash;

/**
 * @author LX
 * @date 2018-11-15 13:28
 */
/*��ʹ���κ��ڽ��Ĺ�ϣ������һ����ϣ����
�����˵��������Ӧ�ð������µĹ���
add(value)�����ϣ�����в���һ��ֵ��  contains(value) �����ع�ϣ�������Ƿ�������ֵ��  remove(value)��������ֵ�ӹ�ϣ������ɾ���������ϣ������û�����ֵ��ʲôҲ������
 ʾ��:  MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // ���� true
        hashSet.contains(3);    // ���� false (δ�ҵ�)
        hashSet.add(2);
        hashSet.contains(2);    // ���� true
        hashSet.remove(2);
        hashSet.contains(2);    // ����  false (�Ѿ���ɾ��)*/
public class MyHashSet {

    private int arr[];

    public MyHashSet() {
        arr = new int[100000];
    }

    public void add(int key) {
        arr[key] = key + 1;
    }

    public void remove(int key) {
        arr[key] = 0;
    }

    /**
     * Returns true if this set did not already contain the specified element
     */
    public boolean contains(int key) {
        return arr[key] == 0 ? false : true;
    }
}
