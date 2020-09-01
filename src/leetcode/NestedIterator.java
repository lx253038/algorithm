package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author LX
 * @Date 2020/9/1 18:29
 * @Description
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> queue = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        fullStack(nestedList);
    }

    private void fullStack(List<NestedInteger> nestedList) {
        for (NestedInteger integer : nestedList) {
            if (integer.isInteger()) {
                queue.add(integer.getInteger());
            } else {
                fullStack(integer.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (queue.size() > 0) {
            return queue.poll();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return queue.size() > 0;
    }

    public static void main(String[] args) {

    }
}
