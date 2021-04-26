package org.rabbit.jp0.practise.offer;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class BinaryTreeSerialize {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    int index = -1;
    TreeNode Deserialize(String str) {
        index++;
        int len = str.length();
        if (index >= len)
            return null;
        String[] strr = str.split(",");
        TreeNode node = null;
        if (!strr[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strr[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }
}
