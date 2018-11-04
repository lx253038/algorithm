package Trie;

import java.util.TreeMap;

/**
 * @author LX
 * @date 2018-11-4 13:19
 */
public class Node {
    private boolean isWord;

    TreeMap<Character, Node> next;

    public Node(boolean isWord) {
        this.isWord = isWord;
        next = new TreeMap<Character, Node>();
    }

    public Node() {
        this(false);
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }

    public TreeMap<Character, Node> getNext() {
        return next;
    }

    public void setNext(TreeMap<Character, Node> next) {
        this.next = next;
    }
}
