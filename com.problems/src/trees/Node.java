package trees;

import java.util.Arrays;
import java.util.List;

class Node {
    Node left;
    Node right;
    int value;

    Node(int value){
        this.value=value;
    }

    Node(){
        super();
    }

    void binaryInsert(int value, Node node){
        if(node.value>=value){
            if(node.left==null) {
                node.left = new Node(value);
            } else {
                binaryInsert(value, node.left);
            }
        } else if (node.value<value){
            if (node.right==null){
                node.left=new Node(value);
            }else {
                binaryInsert(value, node.right);
            }
        }
    }

    boolean binarySearch(int value,Node node){
        if(node.left!=null&&node.left.value<value){
            binarySearch(value,node.left);
        }if(node.right!=null&&node.right.value>value){
            binarySearch(value,node.right);
        }if (node.value==value||node.left!=null&&node.left.value==value||node.right!=null&&node.right.value==value){
            return true;
        }
        return false;
    }

    boolean isLeafNode(Node node){
        if (node.left==null&&node.right==null){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Node node = new Node();
        List<Integer> numberList = Arrays.asList(10,5,15,3,19,4,6);
        numberList.forEach(e->{
            node.binaryInsert(e,node);
        });
        System.out.println(node.binarySearch(6,node));
    }
}