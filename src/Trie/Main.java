package Trie;

/**
 * @author LX
 * @date 2018-11-4 13:44
 */
public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.add("hello-world");
        System.out.println(trie.getSize());

        System.out.println(trie.contain("hello-worl"));
        System.out.println(trie.isPrefix("hello-worl"));
    }
}
