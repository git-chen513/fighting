package bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Baker.chen
 * @create 2020/8/18 14:43
 *
 * 1. 二叉树的叶子数
 *
 * 题目描述：给定一颗二叉树，二叉树每个节点都有一个唯一的正整数值代表节点，在遍历时，我们使用节点的整数值作为标记
 * 输入：二叉树的节点数，前序和中序遍历结果，分别是第一行，第二行和第三行
 * 输出：二叉树叶子节点的个数
 * 备注：注意第一行输入，节点总数不超过3万
 *
 * 示例：
 * 输入：
 * 3
 * 1 3 4
 * 3 1 4
 * 输出
 * 2
 * 说明：3和4是二叉树的两个叶子，所以输出叶子个数为2
 *
 * 思路：可以根据前序遍历和中序遍历的结果构建二叉树，再求解二叉树的叶子节点个数
 */
public class Main1 {
    /**
     * 根据先序遍历和中序遍历构建一颗二叉树，返回二叉树的根节点
     * @param preorder 先序遍历返回的结果数组
     * @param inorder  中序遍历返回的结果数组
     * @return
     */
    public static Node buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        // 先序遍历数组的第一个值为根节点
        int val = preorder[0];
        // 中间变量，用来保存根节点所在中序遍历数组的下标位置
        int temp = 0;
        // 查找根节点所在中序遍历数组的下标位置
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                temp = i;
                break;
            }
        }
        // 创建根节点
        Node root = new Node(val);
        // 递归对根节点的左子树处理
        root.leftChild = buildTree(Arrays.copyOfRange(preorder, 1, 1 + temp), Arrays.copyOfRange(inorder, 0, temp));
        // 递归对根节点的右子树处理
        root.rightChild = buildTree(Arrays.copyOfRange(preorder, 1 + temp, preorder.length), Arrays.copyOfRange(inorder, temp + 1, inorder.length));

        return root;
    }

    /**
     * 计算二叉树的叶子节点数
     * @param root
     * @return
     */
    public static int countLeaf(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return 1;
        }
        return countLeaf(root.leftChild) + countLeaf(root.rightChild);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            inorder[j] = sc.nextInt();
        }
        Node root = buildTree(preorder, inorder);
        System.out.println(countLeaf(root));
    }
}

class Node {
    public int data;
    public Node leftChild;
    public Node rightChild;
    public Node(){
    }
    public Node(int data) {
        super();
        this.data = data;
    }
}

