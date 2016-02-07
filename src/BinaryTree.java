/**
 * Created by Andrew on 2/7/2016.
 */
public class BinaryTree {
    public static void main(String[] args) {
        Tree myTree = new Tree();
        Node displayNode = null;

        myTree.insert(10);
        myTree.insert(2);
        myTree.insert(18);
        myTree.insert(25);
        myTree.insert(13);
        myTree.insert(5);
        myTree.insert(1);
        myTree.insert(0);
        myTree.insert(23);

        for (int i=0; i < 50; i++){
            displayNode = myTree.findData(i);
            if ( displayNode!= null) {
                System.out.println("Value: " + displayNode.getData() + "; Depth: " + displayNode.getDepth());
            }else{
                System.out.println(i + " Not found!");
            }
        }

        System.out.println("Minimum: " + myTree.findMin().getData());
        System.out.println("Maximum: " + myTree.findMax().getData());
    }
}
