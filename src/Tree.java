/**
 * Created by Andrew on 2/7/2016.
 */
public class Tree {
    private Node root;
    public Tree(){
        root = null;
    }

    public void insert (int data){

        /*if (root == null){
            root = new Node();
            root.setData(data);
        }
        else if (root.getData() < data){
            insert(data, root.getNodeRight(), root);
        }
        else if (root.getData() > data){
            insert(data, root.getNodeLeft(), root);
        }*/
    }

    public Node insert(int data, Node current, Node parent){
        if (current == null){
            current = new Node();
            current.setData(data);
            current.setParent(parent);
        }
        else if (root.getData() < data){
            insert(data, root.getNodeRight(), root);
        }
        else if (root.getData() > data){
            insert(data, root.getNodeLeft(), root);
        }

        return current;
    }

}
