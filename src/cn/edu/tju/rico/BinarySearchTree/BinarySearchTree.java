package cn.edu.tju.rico.BinarySearchTree;

public class BinarySearchTree {

    private TreeNode root;

    /**
     * @param input
     * @description 根据已知序列构建二叉搜索树
     * @author rico
     * @created 2017年6月3日 下午6:15:54
     */
    public BinarySearchTree(int[] input) {
        createBinarySearchTree(input);
    }

    /**
     * @param input
     * @description 根据已知序列构建二叉搜索树
     * @author rico
     * @created 2017年6月3日 下午6:15:06
     */
    public void createBinarySearchTree(int[] input) {
        if (input != null) {
            for (int i = 0; i < input.length; i++) {
                root = insert(input[i], root);
            }
        }
    }

    /**
     * @param target 目标值
     * @param root   二叉搜索树的根结点
     * @return
     * @description 二叉搜索树的搜索算法，递归算法
     * @author rico
     * @created 2017年6月3日 下午3:27:43
     */
    public TreeNode search(int target, TreeNode root) {
        TreeNode result = null;
        if (root != null) { // 递归终止条件
            if (target == root.data) { // 递归终止条件
                result = root;
                return result;
            } else if (target < root.data) { // 目标值小于根结点值，从左子树查找
                result = search(target, root.left);
            } else { // 目标值大于根结点值，从右子树查找
                result = search(target, root.right);
            }
        }
        return result;
    }

    /**
     * @param target
     * @param node
     * @return
     * @description 二叉搜索树的插入操作
     * @author rico
     * @created 2017年6月3日 下午5:55:05
     */
    public TreeNode insert(int target, TreeNode node) {
        if (search(target, node) == null) {
            if (node == null) {
                return new TreeNode(target);
            } else {
                if (target < node.data) {
                    node.left = insert(target, node.left);
                } else {
                    node.right = insert(target, node.right);
                }
            }
        }
        return node;
    }

    /**
     * @param target
     * @param node
     * @return
     * @description 删除搜索二叉树的制定结点
     * @author rico
     * @created 2017年6月3日 下午8:43:29
     */
    public TreeNode remove(int target, TreeNode node) {
        TreeNode tmp = null;
        if (node != null) {
            if (target < node.data) { // 从左子树删除
                node.left = remove(target, node.left);
            } else if (target > node.data) { // 从右子树删除
                node.right = remove(target, node.right);
            } else if (node.left != null && node.right != null) { // 找到待删除结点，且其左右子树不为空
                // 找到以待删除结点右子树的中序遍历第一个结点(最小结点)
                tmp = node.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }

                // 用最小结点补位待删除结点
                node.data = tmp.data;

                // 删除待删除结点右子树上补位结点
                node.right = remove(node.data, node.right);
            } else {
                if (node.left == null) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        return node;
    }

    /**
     * @param root
     * @description 中序遍历二叉搜索树，递归算法，升序排序
     * @author rico
     * @created 2017年6月3日 下午3:52:54
     */
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(root.data + " ");
            inOrder(node.right);
        }
    }

    /**
     * @param node
     * @description 打印二叉搜索树
     * @author rico
     * @created 2017年6月3日 下午6:08:42
     */
    public void printTree(TreeNode node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null || node.right != null) {
                System.out.print("(");
                printTree(node.left);
                System.out.print(",");
                printTree(node.right);
                System.out.print(")");
            }
        }
    }

    /**
     * @return
     * @description 访问二叉搜索树的根结点
     * @author rico
     * @created 2017年6月3日 下午3:54:49
     */
    public TreeNode getRoot() {
        return root;
    }
}
