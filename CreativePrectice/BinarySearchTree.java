public class BinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null;
        int[] values = {1,2,8,4,9,90};
        for (int i = 0; i < values.length; i++){
            root = bst.insertNode(root, values[i]);
        }
        bst.inorderedTraversal(root);


    }

    static class Node{
        Node left,right;
        int value;
        Node (int value){
            this.value = value;
        }
    }

    Node insertNode(Node root, int value){
        if (root == null){
            root = new Node(value);
            return root;
        }
        else if(root.value > value){
            root.left = insertNode(root.left, value);
        }
        else{
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    boolean searchNode(Node root, int value){
        if (root == null){
            return false;
        }
        if (root.value == value){
            return true;
        }
        else if (root.value > value){
            return searchNode(root.left, value);
        }
        else{
            return searchNode(root.right, value);
        }
        
    }

    void inorderedTraversal(Node root){
        if (root == null){
            return;
        }
        else{
            inorderedTraversal(root.left);
            System.out.println(root.value);
            inorderedTraversal(root.right);
        }
    }

    Node deleteNode(Node root, int value){
        
    }



    
}
