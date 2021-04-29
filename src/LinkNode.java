import java.util.HashSet;

class ListNode
{
    int val;
    ListNode next;
    ListNode(){};
    ListNode(int val){
        this.val=val;
    }
    ListNode(int val,ListNode next)
    {
        this.val=val;
        this.next=next;
    }
}

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
        ListNode res=findCycle(a1);
        if(res==null)
            System.out.println("no cycle");
        System.out.println(res.val);

    }
    public static ListNode findCycle(ListNode list)
    {
        HashSet<Integer> hashSet=new HashSet<Integer>();
        ListNode head=list;
        while(head!=null)
        {
            if(hashSet.contains(head.val))
                return head;

            hashSet.add(head.val);
            head=head.next;
        }
        if(head==null)
            return null;
        return head;

    }
}
