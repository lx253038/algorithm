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
        } else {
            return false;
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
            searchLeaf(root.left, list);
            searchLeaf(root.right, list);
    }

    public static void main(String[] args) {


        LeafSimilar leafSimilar = new LeafSimilar();
        boolean leafsimilar = leafSimilar.leafsimilar(Array2Tree.listToTree("[3,5,1,6,2,9,8,null,null,7,4]"), Array2Tree.listToTree("[3,5,1,6,7,4,2,null,null,null,null,null,null,9,11,null,null,8,10]"));
        System.out.println(leafsimilar);

    }

}
