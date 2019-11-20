package package1103;

class Node {
    public char val;
    public Node left;
    public Node right;

    public Node(char val) {
        this.val = val;
    }
}

public class BinaryTree {
    // 根节点, 当 root 为 null 的时候, 就是一个空树
    private static Node root = null;

    // 构建一棵树, 构建成一个固定结构的树
    public static Node build() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    // 先序遍历
    public static void prevOrder(Node root) {
        // 先访问根节点, 递归遍历左子树, 递归遍历右子树
        if (root == null) {
            // 空树不需要遍历
            return;
        }
        // 访问就用 打印 来表示
        System.out.print(root.val);
        prevOrder(root.left);
        prevOrder(root.right);
    }

    public static void inOrder(Node root) {
        // 先递归遍历左子树, 访问根节点, 再递归遍历右子树
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);
    }

//    public static int treeSize = 0;
//    public static void size(Node root) {
//        if (root == null) {
//            return;
//        }
//        treeSize++;
//        size(root.left);
//        size(root.right);
//    }

    public static int size(Node root) {
        if (root == null) {
            return 0;
        }
        // 这棵树的节点个数可以理解成:
        // 1 + 左子树的节点个数 + 右子树的节点个数
        return 1 + size(root.left) + size(root.right);
    }

    // 借助遍历的方式, 访问节点的时候, 先判断是不是叶子节点, 如果是就 ++
//    public static int leafSize = 0;
//    public static void getLeafSize(Node root) {
//        if (root == null) {
//            return;
//        }
//        if (root.left == null && root.right == null) {
//            // root 就是叶子节点
//            leafSize++;
//        }
//        getLeafSize(root.left);
//        getLeafSize(root.right);
//    }

    public static int getLeafSize(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 求 root 有多少个叶子节点,
        // 左子树的叶子节点个数 + 右子树的叶子节点个数
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    public static int getKLevelSize(Node root, int k) {
        // 特殊情况
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            // k 为 1 的时候, 就一个根节点
            return 1;
        }
        // 求第 k 层节点的个数,
        // 求左子树的第 k - 1 层节点的个数 + 右子树的 k - 1 层
        return getKLevelSize(root.left, k - 1)
                + getKLevelSize(root.right, k - 1);
    }

    public static void main(String[] args) {
        root = build();
        // prevOrder(root);
        // inOrder(root);
        // postOrder(root);
        // System.out.println(size(root));
        // System.out.println(getLeafSize(root));
        System.out.println(getKLevelSize(root, 3));
    }
}
