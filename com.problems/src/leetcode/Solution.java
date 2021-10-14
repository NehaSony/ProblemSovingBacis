package leetcode;
/**
 * @author Neha Sony
 */

class Solution {
    ListNode merged = null;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<=l2.val){
            if(merged==null){
                merged=new ListNode(l1.val);
                merged.next=new ListNode(l2.val);
                merged=mergeTwoLists(l1.next,l2.next);
            } else{
                merged.next.val=l2.val;
                merged.next.next=new ListNode(l2.val);
                merged=mergeTwoLists(l1.next,l2.next);
            }
        } else{
            if(merged==null){
                merged=new ListNode(l2.val);
                merged.next=new ListNode(l1.val);
                merged=mergeTwoLists(l1.next,l2.next);
            } else{
                merged.next.val=l2.val;
                merged.next.next=new ListNode(l1.val);
                merged=mergeTwoLists(l1.next,l2.next);
            }
        }
        return merged;
    }

    public static void main(String[] args) {

        ListNode l3 = new ListNode(4) ;
        ListNode l2 = new ListNode(2,l3) ;
        ListNode l1 = new ListNode(1,l2) ;

        ListNode l33 = new ListNode(4) ;
        ListNode l22 = new ListNode(3,l33) ;
        ListNode l11 = new ListNode(1,l22) ;
        Solution solution = new Solution();
        printNodes(solution.mergeTwoLists(l1,l11));
    }

    private static void printNodes(ListNode l){
        System.out.print(l);
        if (l.next!=null) {
            System.out.print("->");
            printNodes(l.next);
        }
    }
}