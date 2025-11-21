import static utils.InputUtils.printWithoutLine;

class BinaryTree{
    static int index = -1;
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
            this.left = this.right = null;
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
}

public class tut22 {
    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node root = bt.build(nodes);
        bt.preOrderTraverse(root);
        
    }
    
}
