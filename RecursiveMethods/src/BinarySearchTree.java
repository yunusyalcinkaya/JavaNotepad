/*
*                12
*              5     100
*            2   6
 */
public class BinarySearchTree {

    private static  void addNode(Node root,int data){

        Node node = new Node(data);

        if(root == null){
            root = node;
            return;
        }
        if(root.getData() == node.getData()){
            System.out.println("Value of node data already exists");
        }
        else if(node.getData() < root.getData()){
            if(root.getLeft() == null){
                root.setLeft(node);
            }
            else {
                addNode(root.getLeft(),data);
            }
        }
        else {
            if(root.getRight() == null){
                root.setRight(node);
            }
            else {
                addNode(root.getRight(),data);
            }
        }
    }

    private static Node binarySearch(Node root, int data){

        if(root == null){
            System.out.println("root is null");
            return null;
        }

        if(data == root.getData()){
            return root;
        }
        else if (data < root.getData()) {
            if(root.getLeft() != null){
                return binarySearch(root.getLeft(),data);
            }
        }
        else {
            if(root.getRight() != null){
                return binarySearch(root.getRight(),data);
            }
        }
        System.out.println("data is not exists, ");
        return null;
    }
    // ? as sorted
    private static void printTree(Node root){
        if(root == null){
            System.out.println("root is null");
            return;
        }
        if(root.getLeft() != null){
            printTree(root.getLeft());
        }

        System.out.print(root.getData() + ", ");

        if (root.getRight() != null){
            printTree(root.getRight());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(12);

        addNode(root,5);
        addNode(root,2);
        addNode(root,6);
        addNode(root,100);
        addNode(root,100);//! operation is failed. already exists

        System.out.println(binarySearch(root,6));

        printTree(root);
    }
}

class Node{
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
