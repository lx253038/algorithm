package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LX
 * @date 2018/10/30 14:04
 */
/*
�뿼��һ�Ŷ����������е�Ҷ�ӣ���ЩҶ�ӵ�ֵ�������ҵ�˳�������γ�һ�� Ҷֵ���� ��
        ����:
         3
        /  \
       9   20
          /   \
         15    7
        �ٸ����ӣ�����ͼ��ʾ������һ��Ҷֵ����Ϊ (9, 15, 7) ������
        ��������Ŷ�������Ҷֵ��������ͬ����ô���Ǿ���Ϊ������ Ҷ���� �ġ�
        �������������ͷ���ֱ�Ϊ root1 �� root2 ������Ҷ���Ƶģ��򷵻� true�����򷵻� false ��
*/


public class LeafSimilar {
    public boolean leafsimilar(TreeNode root1, TreeNode root2) {

        List<Integer> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        searchLeaf(root1, s1);
        searchLeaf(root2, s2);
        if (s1.size() == s2.size()) {
            for (int i = 0; i < s1.size(); i++) {
                if (!s1.get(i).equals(s2.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    private void searchLeaf(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.left != null) {
            searchLeaf(root.left, list);
        }
        if (root.right != null) {
            searchLeaf(root.right, list);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(100);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(8);

        LeafSimilar leafSimilar = new LeafSimilar();
        boolean leafsimilar = leafSimilar.leafsimilar(root, root1);
        System.out.println(leafsimilar);

    }

}
