/**
 * Created by Andrew on 2/7/2016.
 */
public class Tree {

    //TODO to implement findMin()
    //TODO to implement findMax()

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

            if (parent != null)
                current = new Node(parent.getDepth()+1);


            current.setData(data);
            current.setParent(parent);
            //System.out.println("depth: "+ current.getDepth() +" root " + current.getData());
        }
        else if (current.getData() < data){
            current.setNodeRight( insert(data, current.getNodeRight(), current) );
  //          System.out.println("depth: "+ current.getNodeRight().getDepth() +" right " + current.getNodeRight().getData());
        }
        else if (current.getData() > data){
            current.setNodeLeft( insert(data, current.getNodeLeft(), current) );
    //        System.out.println("depth: "+ current.getNodeLeft().getDepth() +" left " + current.getNodeLeft().getData());
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

        if (current.getNodeLeft() == null){
            result = current;
        }
        else{
            result = findMin(current.getNodeLeft());
        }

        return result;
    }

    public Node findMax(){
        return findMax(root);
    }

    private Node findMax(Node current){
        Node result = null;

        if (current.getNodeRight() == null){
            result = current;
        }
        else{
            result = findMax(current.getNodeRight());
        }

        return result;
    }
}
