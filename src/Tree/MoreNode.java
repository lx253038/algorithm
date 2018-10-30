package Tree;

import java.util.List;

/**
 * @author LX
 * @date 2018/10/30 15:13
 */
//N²æÊ÷
public class MoreNode {
    public int val;
    public List<MoreNode> children;

    public MoreNode() {
    }

    public MoreNode(int _val, List<MoreNode> _children) {
        val = _val;
        children = _children;
    }
}
