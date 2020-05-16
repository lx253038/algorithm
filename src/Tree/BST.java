package Tree;

/**
 * @Author LX
 * @Date 2020/5/6 21:04
 * @Description 模拟实现二分搜索树相关操作
 */
public class BST<E extends Comparable<E>> {

    private Node root;

    private int size;

    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    private class Node<E extends Comparable<E>> {
        E element;
        Node left;
        Node right;

        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public BST() {
        root = null;
        size = 0;
    }


    private Node addElement(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (node.element.compareTo(e) > 0) {
            node.left = addElement(e, node.left);
        } else if ((node.element.compareTo(e) < 0)) {
            node.right = addElement(e, node.right);
        }
        return node;
    }

    private boolean contains(E e, Node node) {
        if (node == null) {
            return false;
        }

        if (node.element.compareTo(e) > 0) {
            return contains(e, node.left);
        } else if ((node.element.compareTo(e) < 0)) {
            return contains(e, node.right);
        } else {
            return true;
        }

    }

    public void add(E element) {
        root = addElement(element, root);
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E element) {

        return contains(element, root);
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(100);
        bst.add(55);
        bst.add(22);
        bst.add(11);
        bst.add(200);
        System.out.println(bst);
        System.out.println(bst.contains(551));
    }
}
