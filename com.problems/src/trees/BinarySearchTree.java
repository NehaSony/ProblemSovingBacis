package trees;

import java.util.Arrays;
import java.util.List;

public class BinarySearchTree extends Node{
    boolean isVisited;

    boolean binarySearch(int value,Node node){
        if(node.left!=null&&node.left.value<value){
            binarySearch(value,node.left);
        }if(node.right!=null&&node.right.value>value){
            binarySearch(value,node.right);
        }if (node.value==value||node.left.value==value||node.right.value==value){
            return true;
        }
        return false;
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
