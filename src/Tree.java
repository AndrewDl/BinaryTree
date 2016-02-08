/**
 * Created by Andrew on 2/7/2016.
 */
public class Tree {

    //TODO make tree traverse

    public enum traverseType{
        INORDER,
        PREORDER,
        POSTORDER
    }

    private Node root;

    public Tree(){
        root = null;
    }

    public void insert (int data){
        root = insert(data, root, null);
    }

    private Node insert(int data, Node current, Node parent){
        if (current == null){
            current = new Node();

            current.setData(data);
            current.setParent(parent);
            //System.out.println("depth: "+ current.getDepth() +" root " + current.getData());
        }
        else if (current.getData() < data){
            current.setNodeRight( insert(data, current.getNodeRight(), current) );
        }
        else if (current.getData() > data){
            current.setNodeLeft( insert(data, current.getNodeLeft(), current) );
        }

        return current;
    }

    public Node findData(int data){
        return findData(root, data);
    }

    private Node findData(Node current, int data) {
        Node result = null;

        if (current == null){
            result = null;
        }else if (current.getData() == data) {
            result = current;
        }else if (current.getData() < data){
            result = findData(current.getNodeRight(), data);
        }else{
            result = findData(current.getNodeLeft(), data);
        }

        return result;
    }

    public Node findMin(){
        return findMin(root);
    }

    private Node findMin(Node current){
        Node result = null;

        if (current != null) {
            if (current.getNodeLeft() == null) {
                result = current;
            } else {
                result = findMin(current.getNodeLeft());
            }
        }
        return result;
    }

    public Node findMax(){
        return findMax(root);
    }

    private Node findMax(Node current){
        Node result = null;

        if (current != null) {
            if (current.getNodeRight() == null) {
                result = current;
            } else {
                result = findMax(current.getNodeRight());
            }
        }
        return result;
    }

    public void remove (int data){
        remove(data, root);
    }

    private void remove(int data, Node startNode) {
        Node removeNod = findData(startNode,data);

        //analyze node
        boolean isRightNode = false;

        if (removeNod.getParent() != null) {
            isRightNode = removeNod.getParent().getData() < removeNod.getData();
        }
        //case 1: no children
        if ( (removeNod.getNodeLeft() == null) && (removeNod.getNodeRight()) == null ){
            if (isRightNode){
                removeNod.getParent().setNodeRight(null);
            } else {
                removeNod.getParent().setNodeLeft(null);
            }
        }
        //case 2: has left child
        else if ( (removeNod.getNodeLeft() != null) && (removeNod.getNodeRight()) == null ){
            if (isRightNode){
                removeNod.getParent().setNodeRight( removeNod.getNodeLeft() );
            } else {
                removeNod.getParent().setNodeLeft( removeNod.getNodeLeft() );
            }
        }
        //case 3: has right child
        else if ( (removeNod.getNodeLeft() == null) && (removeNod.getNodeRight()) != null ){
            if (isRightNode){
                removeNod.getParent().setNodeRight( removeNod.getNodeRight() );
            } else {
                removeNod.getParent().setNodeLeft( removeNod.getNodeRight() );
            }
        }
        //case 4: 2 children
        else {
            //substitute by minimum from the right branch
            Node rightMin = findMin(removeNod.getNodeRight());

            //duplicate data into
            remove(rightMin.getData(), removeNod.getNodeRight());
            removeNod.setData( rightMin.getData() );


            System.out.println();
        }
    }

    public void traverse(traverseType type){
        System.out.println("Traverse start");
        traverse(root, type);
        System.out.println();
    }

    private void traverse(Node startNoode, traverseType type){
        if (startNoode == null) return;
        switch (type){
            case INORDER:
                traverse(startNoode.getNodeLeft(), type);
                System.out.print(" " + startNoode.getData());
                traverse(startNoode.getNodeRight(), type);
                break;
            case PREORDER:
                System.out.print(" " + startNoode.getData());
                traverse(startNoode.getNodeLeft(), type);
                traverse(startNoode.getNodeRight(), type);
                break;
            case POSTORDER:
                traverse(startNoode.getNodeLeft(), type);
                traverse(startNoode.getNodeRight(), type);
                System.out.print(" " + startNoode.getData());
                break;
        }
    }
}
