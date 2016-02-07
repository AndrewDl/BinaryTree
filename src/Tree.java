/**
 * Created by Andrew on 2/7/2016.
 */
public class Tree {
    private Node root;
    public Tree(){
        root = null;
    }

    public void insert (int data){
        root = insert(data, root, null);
    }

    public Node insert(int data, Node current, Node parent){
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
            System.out.println("depth: "+ current.getNodeRight().getDepth() +" right " + current.getNodeRight().getData());
        }
        else if (current.getData() > data){
            current.setNodeLeft( insert(data, current.getNodeLeft(), current) );
            System.out.println("depth: "+ current.getNodeLeft().getDepth() +" left " + current.getNodeLeft().getData());
        }

        return current;
    }

}
