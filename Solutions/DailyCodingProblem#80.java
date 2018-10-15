//This problem was asked by Google.
//
//        Given the root of a binary tree, return a deepest node. For example, in the following tree, return d.
//
//        a
//        / \
//        b   c
//        /
//        d

public class DailyCodingProblem {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private static void deepestNode(Node root) {
        int depth = height(root);

        findDeepElement(root, depth);
    }

    private static void findDeepElement(Node root, int depth) {
        if (root != null) {
            if (depth == 1)
                System.out.print(root.data);
            else {
                findDeepElement(root.right, depth - 1);
                findDeepElement(root.left, depth - 1);
            }
        }
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lDepth = height(root.left);
        int rDepth = height(root.right);

        if (lDepth > rDepth) {
            return lDepth + 1;
        } else {
            return rDepth + 1;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.right = new Node(7);
        root.right.right.right = new Node(8);
        root.right.left.right.left = new Node(9);

        deepestNode(root);
    }
}
