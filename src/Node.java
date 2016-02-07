/**
 * Created by Andrew on 2/7/2016.
 */
public class Node {
    private int data;
    private Node nodeLeft;
    private Node nodeRight;
    private Node parent;

    public Node getNodeLeft(){
        return nodeLeft;
    }

    public void setNodeLeft(Node node){
        nodeLeft = node;
    }

    public Node getNodeRight(){
        return nodeRight;
    }

    public void setNodeRight(Node node){
        nodeRight = node;
    }

    public void setParent (Node node){
        parent = node;
    }

    public Node getParent(){
        return parent;
    }

    public int getData(){
        return data;
    }

    public void setData(int data){
        this.data = data;
    }
}
