import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by Andrew on 2/7/2016.
 */
public class Node {


    private int data;
    private Node nodeLeft;
    private Node nodeRight;
    private Node parent;

    private int depth = 0;

    public Node(){

    }

    public Node(int depth){
        this.depth = depth;
    }

    public Node getNodeLeft(){
        return nodeLeft;
    }

    public void setNodeLeft(Node node){
        nodeLeft = node;
        if (nodeLeft!= null)
            nodeLeft.setParent(this);
    }

    public Node getNodeRight(){
        return nodeRight;
    }

    public void setNodeRight(Node node){
        nodeRight = node;
        if (nodeRight != null)
            nodeRight.setParent(this);
    }

    public void setParent (Node node){
        parent = node;
        if (parent != null) setDepth(parent.getDepth()+1);
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

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
}
