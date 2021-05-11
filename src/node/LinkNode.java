package node;


public class LinkNode {
    public static  void main(String args[])
    {
        ListNode a1=new ListNode(3);
        ListNode a2=new ListNode(2);
        ListNode a3=new ListNode(0);
        ListNode a4=new ListNode(-4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a2;
        FindCycle findCycle=new FindCycle();
        ListNode res=findCycle.findCycleNode(a1);
        if(res==null)
            System.out.println("no cycle");
        System.out.println(res.val);

    }

}
