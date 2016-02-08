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
        myTree.insert(4);
        myTree.insert(8);
        myTree.insert(7);
        myTree.insert(9);

        myTree.remove(8);


        for (int i=-50; i < 50; i++){
            displayNode = myTree.findData(i);
            if ( displayNode!= null) {
                System.out.println("Value: " + displayNode.getData() + "; Depth: " + displayNode.getDepth());
            }else{
             //   System.out.println(i + " Not found!");
            }
        }

        if ( (myTree.findMin() == null) || (myTree.findMax() == null) ) {
            System.out.println("Tree is empty");
        }
        else{
            System.out.println("Minimum: " + myTree.findMin().getData());
            System.out.println("Maximum: " + myTree.findMax().getData());
        }


        myTree.traverse(Tree.traverseType.INORDER);
        myTree.traverse(Tree.traverseType.PREORDER);
        myTree.traverse(Tree.traverseType.POSTORDER);
    }
}

