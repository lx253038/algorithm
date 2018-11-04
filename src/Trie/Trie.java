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

    //获取Trie中元素个数
    public int getSize() {
        return size;
    }

    //向Trie中添加元素
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

    //查询Trie中是否存在某元素
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

    //查询Trie中是否有以prefix为前缀的单词
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
