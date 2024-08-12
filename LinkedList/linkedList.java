import org.w3c.dom.Node;

public class linkedList {
    public static class NODE{
        int data;
        NODE next;

        public NODE(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static NODE head;
    public static NODE tail;

    public void addFirst(int data){
        NODE temp = new NODE(data);
        if(head==null){
            head = tail = temp;
            return;
        }
        temp.next = head;
        head = temp;
    }

    public void addLast(int data){
        NODE temp = new NODE(data);
        if(head == null){
            head=tail=temp;
        }
        tail.next = temp;
        tail = temp;
    }

    public void traverse(){
        if(head==null){
            System.out.println("empty linked list");
            return;
        }
        NODE p1 = head;
        while(p1!=null){
            System.out.print(p1.data+ " ");
            p1=p1.next;
        }
    }

    public void addMiddle(int idx,int data){
        NODE temp = new NODE(data);
        NODE p1 = head;
        int i =0;
        while(i<idx-1){
            p1=p1.next;
            i++;
        }
        temp.next = p1.next;
        p1.next=temp;

    }
    public int removeFirst(){
        int val = head.data;
        head=head.next;
        return val;
    }

    public int search(int key){
        NODE p1 = head;
        int i = 0;
        while(p1!=null){
            if(p1.data==key){
                System.out.println("key found at index "+i);
                return i;
            }
            p1=p1.next;
            i++;
        }
        return -1;
    }
    public void reverse(){
        NODE prev = null;
        NODE curr = head;
        NODE next;
        while(curr!=null){
            next = curr.next;
            curr.next=prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public NODE findMid(NODE head){
        NODE slow=head;
        NODE fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head==null  || head.next==null){
            return true;
        }
        NODE mid = findMid(head);
        NODE prev=null;
        NODE curr = mid;
        NODE next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        NODE left = head;
        NODE right = prev;

        while(right!=null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    //to check cycle/loop in a list
    public static boolean isCycle(){
        NODE slow = head;
        NODE fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        NODE slow = head;
        NODE fast = head;
        boolean cycle = false;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                cycle = true;
            }
        }

        if(cycle == false){
            return;
        }
        slow = head;
        NODE prev = null;
        while(slow!=fast){
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }

    public NODE getMid(NODE head){
        NODE slow = head;
        NODE fast = head.next;
        while(fast!=null&&fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public NODE mergeSort(NODE head){
        if(head==null || head.next==null){
            return head;
        }
        //finding middle element
        NODE mid = getMid(head);

        //right head;
        NODE rightHead = mid.next;
        mid.next = null;
        NODE newLeft = mergeSort(head);
        NODE newRight = mergeSort(rightHead);
        return merge(newLeft,newRight);
    }

    public NODE merge(NODE head1,NODE head2){
        NODE mergeLL = new NODE(-1);
        NODE temp = mergeLL;
        while(head1!=null&&head2!=null){
            if(head1.data<=head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1!=null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2!=null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }


        public static void main(String[] args) {
        linkedList ll = new linkedList();
        ll.addFirst(5);
        ll.addLast(20);
        ll.addLast(15);
        ll.addFirst(10);
        ll.traverse();
        System.out.println();
        // ll.addMiddle(3, 17);
        // ll.traverse();
        // ll.search(17);
        // ll.reverse();
        // ll.traverse();
        // System.out.println(ll.checkPalindrome());
        // System.out.println(isCycle());
        ll.head = ll.mergeSort(ll.head);
        ll.traverse();
    }
}
