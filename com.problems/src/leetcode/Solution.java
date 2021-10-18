package leetcode;
/**
 * @author Neha Sony
 */

class Solution {

    ListNode merged = new ListNode(-1);

    ListNode head = merged;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2,ListNode head) {
        if(list1 != null && list2 != null){
            if(list1.val<= list2.val){
                head=list1;
                list1=list1.next;
                head.next=list2;
                list2=list2.next;

            }else {
                head=list2;
                list2=list2.next;
                head.next=list1;
                list1=list1.next;
            }
            mergeTwoLists(list1, list2, head.next.next);
        }
       return merged;
    }

    public static void main(String[] args) {

        ListNode l3 = new ListNode(4) ;
        ListNode l2 = new ListNode(2,l3) ;
        ListNode l1 = new ListNode(1,l2) ;
        printNodes(l1);

        ListNode l33 = new ListNode(4) ;
        ListNode l22 = new ListNode(3,l33) ;
        ListNode l11 = new ListNode(1,l22) ;
        Solution solution = new Solution();
        printNodes(l11);
        printNodes(solution.mergeTwoLists(l1,l11, solution.merged));
    }

    private static void printNodes(ListNode l){
        System.out.print(l);
        if (l.next!=null) {
            System.out.print("->");
            printNodes(l.next);
        }
        System.out.println();
    }
}