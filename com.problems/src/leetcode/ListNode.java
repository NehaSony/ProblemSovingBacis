package leetcode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

   public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return  String.valueOf(val);
    }


    static class Solution {
        ListNode sum = null;
        int carry = 0;
        private ListNode nextNode;
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(sum ==null){
                nextNode = new ListNode((l1.val+l2.val)%10);
                if(l1.next!=null&&l2.next!=null)
                    nextNode.next=new ListNode();
                sum = nextNode;
            } else {
                if(nextNode.next!=null)
                    nextNode = nextNode.next;
                else nextNode.next=new ListNode();
                nextNode.val=((l1.val+l2.val)+carry)%10;
                if(l1.next!=null&&l2.next!=null)
                    nextNode.next=new ListNode();
            }
            carry = ((l1.val+l2.val)+carry)/10;
            if (carry>0)
                nextNode.next=new ListNode(carry);
            if(l1.next!=null||l2.next!=null){
                if(l1.next==null)
                    l1.next=new ListNode(0,new ListNode());
                if(l2.next==null)
                    l2.next=new ListNode(0,new ListNode());
                addTwoNumbers(l1.next,l2.next);
            }
            return sum;
        }
        public ListNode addTwoNumbersFinal(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode p = l1, q = l2, curr = dummyHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) p = p.next;
                if (q != null) q = q.next;
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] args) {
       /* ListNode l1 = new ListNode(3) ;
        ListNode l2 = new ListNode(5,l1) ;
        ListNode l3 = new ListNode(2,l2) ;
        ListNode l4 = new ListNode(4) ;
        ListNode l5 = new ListNode(6,l4) ;
        ListNode l6 = new ListNode(5,l5) ;*/

        ListNode l1 = new ListNode(9) ;
        ListNode l2 = new ListNode(9,l1) ;
        ListNode l3 = new ListNode(9,l2) ;
        ListNode l4 = new ListNode(9) ;
        ListNode l5 = new ListNode(9,l4) ;
        ListNode l6 = new ListNode(9,l5) ;
        ListNode l7 = new ListNode(9,l6) ;
        ListNode l8 = new ListNode(9,l7) ;
        Solution add = new Solution();
        printNodes(l8);
        System.out.println();
        printNodes(l3);
        System.out.println();
        printNodes(add.addTwoNumbers(l8,l3));


    }

    private static void printNodes(ListNode l){
        System.out.print(l);
        if (l.next!=null) {
            System.out.print("->");
            printNodes(l.next);
        }
    }
}
