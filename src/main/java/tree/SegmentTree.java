package tree;

/**
 * This is a simple segment tree implementation
 * for range sum in integer arrays.
 */
public class SegmentTree {

    private static class Node {
        int lo;
        int hi;
        int sum;
        Node left;
        Node right;

        Node(int lo, int hi, int sum) {
            this.lo = lo;
            this.hi = hi;
            this.sum = sum;
        }

        int update(int index, int val) {
            int res;
            if (this.lo == this.hi && index == this.lo) {
                res = val - this.sum;
                this.sum = val;
            } else if (index <= mid(this.lo, this.hi)) {
                res = this.left.update(index, val);
                this.sum += res;
            } else {
                res = this.right.update(index, val);
                this.sum += res;
            }
            return res;
        }

        int rangeSum(int i, int j) {
            if (i > j) {
                return 0;
            }
            if (this.lo == this.hi) {
                return this.sum;
            }
            int mid = mid(this.lo, this.hi);
            if (i > mid) {
                return this.right.rangeSum(i, j);
            } else if (j <= mid) {
                return this.left.rangeSum(i, j);
            } else {
                return this.left.rangeSum(i, j) + this.right.rangeSum(i, j);
            }
        }
    }

    private int[] original;
    private Node root;

    public SegmentTree(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Cannot use null or empty array to initialize segment tree");
        }
        this.original = array;
        this.root = build(array, 0, array.length - 1);
    }

    public void update(int index, int val) {
        this.original[index] = val;
        this.root.update(index, val);
    }

    public int rangeSum(int i, int j) {
        return this.root.rangeSum(i, j);
    }

    private static Node build(int[] array, int i, int j) {
        if (i == j) {
            return new Node(i, j, array[i]);
        }
        int mid = mid(i, j);
        Node left = build(array, i, mid);
        Node right = build(array, mid + 1, j);
        Node current = new Node(i, j, left.sum + right.sum);
        current.left = left;
        current.right = right;
        return current;
    }

    private static int mid(int lo, int hi) {
        return lo + (hi - lo) / 2;
    }
}
