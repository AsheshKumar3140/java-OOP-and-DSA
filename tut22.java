import static utils.InputUtils.print;
import static utils.InputUtils.printWithoutLine;

import java.util.ArrayDeque;
import java.util.Queue;

class BinaryTree{
    static int index = -1;
    public class Node{
        int data;
        Node left;
        Node right;
        int height;
        int diameter;
        Node(int d){
            this.data = d;
            this.left = this.right = null;
            this.height = 0;
            this.diameter = 0;
        }
    }

    public Node build(int nodes[]){
        index++;
        if(nodes[index]==-1) return null;
        Node newNode = new Node(nodes[index]);
        newNode.left = build(nodes);
        newNode.right = build(nodes);
        return newNode;

    }

    public void preOrderTraverse(Node root){
        if(root == null) {printWithoutLine(" -1"); return;};
        printWithoutLine(" " + root.data);
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }

    public void inOrderTraverse(Node root){
        if(root == null){ printWithoutLine(" -1"); return;}
        inOrderTraverse(root.left);
        printWithoutLine(" " + root.data);
        inOrderTraverse(root.right);
    }

    public void postOrderTraverse(Node root){
        if(root == null){ printWithoutLine(" -1"); return;}
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        printWithoutLine(" " + root.data);
    }


    public void levelOrder(Node root){
        if(root == null) return;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            Node curr = q.remove();
            printWithoutLine(" " + curr.data);
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }
    }

    public int countNodes(Node root){
        if(root==null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    public int countNodesData(Node root){
        if(root==null) return 0;
        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);
        return leftNodes + rightNodes + root.data;
    }

    public int findHeight(Node root){
        if(root == null) return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
    }

    public int diameter(Node root){
        if(root == null) return 0;
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        int dia = findHeight(root.left) + findHeight(root.right) + 1;
        return Math.max(dia, Math.max(rightDiameter, leftDiameter));
    }

    public Node diameter2(Node root){
        if (root == null) return null;

        Node leftNode = diameter2(root.left);
        Node rightNode = diameter2(root.right);

        int leftHeight = (leftNode == null) ? 0 : leftNode.height;
        int rightHeight = (rightNode == null) ? 0 : rightNode.height;

        int leftDiameter = (leftNode == null) ? 0 : leftNode.diameter;
        int rightDiameter = (rightNode == null) ? 0 : rightNode.diameter;

        root.height = Math.max(leftHeight, rightHeight) + 1;
        int passThroughRoot = leftHeight + rightHeight + 1;
        root.diameter = Math.max(passThroughRoot, Math.max(leftDiameter, rightDiameter));

        return root;
    }

    public void printDiameter2(Node root){
        print("Diameter 2: " + diameter(root));
    }

    public class Info{
        int height;
        int diameter;
        Info(int h, int d){
            this.height = h;
            this.diameter = d;
        }
    }
    public Info diameterWithHelperClass(Node root){
        if(root == null) return new Info(0,0);
        
        Info leftNode = diameterWithHelperClass(root.left);
        Info rightNode = diameterWithHelperClass(root.right);

        int height = Math.max(leftNode.height, rightNode.height) + 1;
        int passThroughRoot = leftNode.height + rightNode.height + 1;
        int diameter = Math.max(passThroughRoot, Math.max(leftNode.diameter, rightNode.diameter));

        return new Info(height, diameter);
    }

    public boolean isIdentical(Node root, Node subroot){
        if(root==null && subroot==null) return true;
        if(root==null || subroot==null) return false;
        if(root.data != subroot.data) return false;
        return isIdentical(root.left, subroot.left) && isIdentical(root.right, subroot.right);
    }
    public boolean isSubtree(Node root, Node subroot){
        if(root == null) return false;
        if(subroot == null) return true;
        if(root.data == subroot.data){
            if(isIdentical(root, subroot)) return true;
        }
        return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);

    }
    
}


public class tut22 {
    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,4,-1,-1};
        int subNodes[] = {1,4,-1,-1,5,-1,-1};
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node root = bt.build(nodes);
        bt.preOrderTraverse(root);
        print("");
        bt.inOrderTraverse(root);
        print("");
        bt.postOrderTraverse(root);
        print("");
        bt.levelOrder(root);

        print("\nCount of nodes: " + bt.countNodes(root));
        print("Sum of nodes data: " + bt.countNodesData(root));
        print("Height: " + bt.findHeight(root));
        print("Diameter: " + bt.diameter(root));
        bt.printDiameter2(root);
        print("Diameter 3: " + bt.diameterWithHelperClass(root).diameter);

        BinaryTree.index = -1;
        BinaryTree subtree = new BinaryTree();
        BinaryTree.Node subRoot = subtree.build(subNodes);
        bt.levelOrder(subRoot);
        print("\nAre trees identical? : " + bt.isSubtree(root, subRoot));
        
    }
    
}
