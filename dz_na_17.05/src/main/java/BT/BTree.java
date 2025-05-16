package BT;

public class BTree {

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);

        return "(" + root.val + ", " + left + ", " + right + ")";
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        String serialized = serialize(root);
        System.out.println(serialized);
    }
}