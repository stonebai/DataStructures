package tree;

import org.junit.Test;

/**
 * This is the unit test for the Segment Tree.
 */
public class SegmentTreeUnitTest {
    @Test
    public void basicTest() {
        int[] array = new int[3];
        for (int i = 0;i < array.length;i++) {
            array[i] = i;
        }
        SegmentTree segTree = new SegmentTree(array);
        assert segTree.rangeSum(0, 2) == 3;
        assert segTree.rangeSum(0, 1) == 1;
        segTree.update(0, 9);
        segTree.update(2, 7);
        assert segTree.rangeSum(0, 2) == 17;
        assert segTree.rangeSum(0, 1) == 10;
        assert segTree.rangeSum(2, 2) == 7;
    }
}
