package leetcode;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
               */

public class AddTwoNumbers {
    ListNode sum = null;
    int carry = 0;
    ListNode nextNode=null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         if(sum ==null){
             nextNode = new ListNode((l1.val+l2.val)%10,new ListNode());
             sum = nextNode;
         } else {
             nextNode = nextNode.next;
             nextNode=new ListNode((l1.val+l2.val)%10+carry,new ListNode());
         }
         carry = (l1.val+l2.val)/10;
        if(l1.next!=null&&l2.next!=null){
         addTwoNumbers(l1.next,l2.next);
     }
     return sum;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3) ;
        ListNode l2 = new ListNode(5,l1) ;
        ListNode l3 = new ListNode(2,l2) ;
        ListNode l4 = new ListNode(4) ;
        ListNode l5 = new ListNode(6,l4) ;
        ListNode l6 = new ListNode(5,l5) ;
        AddTwoNumbers add = new AddTwoNumbers();
        printNodes(l3);
        System.out.println();
        printNodes(l6);
        System.out.println();
        printNodes(add.addTwoNumbers(l3,l6));


    }

    private static void printNodes(ListNode l){
            System.out.print(l);
        if (l.next!=null) {
            System.out.print("->");
            printNodes(l.next);
        }
    }

}
