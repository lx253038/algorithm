package Trie;

/**
 * @author LX
 * @date 2018-11-4 13:21
 */
public class Trie {
    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    //��ȡTrie��Ԫ�ظ���
    public int getSize() {
        return size;
    }

    //��Trie�����Ԫ��
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord()) {
            cur.setWord(true);
            size++;
        }
    }

    //��ѯTrie���Ƿ����ĳԪ��
    public boolean contain(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord();

    }

    //��ѯTrie���Ƿ�����prefixΪǰ׺�ĵ���
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char d = prefix.charAt(i);
            if (!cur.next.containsKey(d)) {
                return false;
            }
            cur = cur.next.get(d);
        }
        return true;

    }


}
