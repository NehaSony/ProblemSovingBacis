package trees;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTree extends Node{
    boolean isVisited;

    boolean isNodeVisited(BinarySearchTree binarySearchTree){
        if(binarySearchTree.isVisited==true)
            return true;
        return false;
    }

    boolean binarySearch(int value,BinarySearchTree binarySearchTree){
        if(binarySearchTree.left!=null&&binarySearchTree.left.value<value){
            binarySearch(value,binarySearchTree.left);
        }if(binarySearchTree.right!=null&&binarySearchTree.right.value>value){
            binarySearch(value,binarySearchTree.right);
        }if (binarySearchTree.value==value||binarySearchTree.left.value==value||binarySearchTree.right.value==value){
            return true;
        }
        return false;
    }

    void inorder(BinarySearchTree binarySearchTree){
//        if(binarySearchTree.left==null||binarySearchTree.isVisited(binarySearchTree.left)){
//
//        }
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        List<Integer> numberList = Arrays.asList(10,5,15,3,19,4,6);
        numberList.forEach(e->{
            binarySearchTree.binaryInsert(e,binarySearchTree);
        });
        System.out.println(binarySearchTree.binarySearch(6,binarySearchTree));
    }
}
